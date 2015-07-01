package com.example
// Use H2Driver to connect to an H2 database
import slick.backend.DatabasePublisher
import slick.driver.H2Driver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.meta._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._


case class Person(id: Int, firstname: String, lastname: String)

class People(tag: Tag) extends Table[Person](tag, "PEOPLE") {
	def id = column[Int]("PERSON_ID", O.PrimaryKey, O.AutoInc)
	def firstname = column[String]("PERSON_FIRSTNAME")
	def lastname = column[String]("PERSON_LASTNAME")
	def * = (id, firstname, lastname) <> (Person.tupled, Person.unapply)
}

object PeopleDAO {
	val db = Database.forConfig("test1")
	val people = TableQuery[People]

	def createTable() {
		val query = people.schema.create
		val action = db.run(query)
		val future = action map { _ =>
			println("table created")
		}
		Await.result(future, Duration.Inf)
	}

	def checkTable(tabName: String) {
		val query = MTable.getTables(tabName)
		val action = db.run(query)
		val future = action.map {result =>
			result map {x => println(x); x.name.name}
		}
		Await.result(future, Duration.Inf)
	}
}