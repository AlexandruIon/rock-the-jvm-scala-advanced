package scalaCookbook.c5Methods

import java.io.IOException
import javax.sound.sampled.{LineUnavailableException, UnsupportedAudioFileException}

object DeclaringAMethodThrowAnException extends App {

  //You want to declare that a method can throw an exception, either to alert callers
  // to this fact or because your method will be called from Java code.

  //the @throws annotation is the Scala way of providing the throws method signature to Java consumers

  @throws(classOf[IOException])
  @throws(classOf[LineUnavailableException])
  @throws(classOf[UnsupportedAudioFileException])
  def playSoundFileWithJavaAudio {
    // exception throwing code here ...
  }
}
