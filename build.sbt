name := "UT-IT task"

version := "0.1"

scalaVersion := "2.13.4"
// Dependecies
val sharedDependencies = Seq(
  // test dependecies
  "org.scalatest" %% "scalatest" % "3.1.1" % Test,
  "org.mockito" %% "mockito-scala" % "1.5.12" % Test
)


// Modules
lazy val Ques1and2 = project.in(file("Ques1and2" ))
  .settings( libraryDependencies ++= sharedDependencies)

lazy val Ques3= project.in(file("Ques3"))
  .settings( libraryDependencies ++= sharedDependencies)


lazy val root = project.in(file(".")).aggregate(Ques1and2, Ques3)