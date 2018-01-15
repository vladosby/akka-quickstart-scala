//package com.lightbend.akka.sample
//
//import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
//
//object AkkaApp extends App {
//  private val system = ActorSystem("akka-container")
//
//  private val printerActor: ActorRef = system.actorOf(Printer.props, "printerActor")
//
//  private val greeterActor: ActorRef = system.actorOf(Greeter.props("Hi", printerActor), "greeterActor")
//
//  printerActor ! Greeting("Hello, Vlad")
//
//  greeterActor ! WhoToGreet("Vasya")
//  greeterActor ! SendMsg
//  greeterActor ! SendMsg
//
//
//}
//
//class Printer extends Actor with ActorLogging {
//  var count = 0
//
//  def receive = {
//    case Greeting(msg) => {
//      count += 1
//      log.info(s"coiunt = $count")
//      log.info(s"$msg")
//    }
//    case _ => {
//      count += 1
//      log.info(s"coiunt = $count")
//      log.info("send incorrect message")
//    }
//
//  }
//}
//
//object Printer {
//  def props: Props = Props[Printer]
//}
//
//case class Greeting(msg: String)
//
//class Greeter(msg: String, printActor: ActorRef) extends Actor {
//  var message = ""
//
//  def receive = {
//    case WhoToGreet(name) => message = s"$msg, $name!"
//    case SendMsg => printActor ! Greeting(message)
//  }
//}
//
//object Greeter {
//  def props(msg: String, printActor: ActorRef): Props = Props(new Greeter(msg, printActor))
//}
//
//case class WhoToGreet(name: String)
//
//case object SendMsg
