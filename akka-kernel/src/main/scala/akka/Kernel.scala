/**
 * Copyright (C) 2009-2010 Scalable Solutions AB <http://scalablesolutions.se>
 */

package akka.kernel

import akka.http.EmbeddedAppServer
import akka.servlet.AkkaLoader
import akka.remote.BootableRemoteActorService
import akka.actor.BootableActorLoaderService
import akka.camel.CamelService

object Main {
  def main(args: Array[String]) = Kernel.boot
}

/**
 * The Akka Kernel, is used to start And postStop Akka in standalone/kernel mode.
 *
 * @author <a href="http://jonasboner.com">Jonas Bon&#233;r</a>
 */
object Kernel extends AkkaLoader {
  //This is what we run :-)
  def boot(): Unit = boot(true, new EmbeddedAppServer with BootableActorLoaderService with BootableRemoteActorService with CamelService)

    //For testing purposes only
  def startRemoteService(): Unit = bundles.foreach( _ match {
    case x: BootableRemoteActorService => x.startRemoteService
    case _ =>
  })
}
