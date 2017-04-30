package resume

import better.files._
import java.awt.Desktop
import org.rogach.scallop._
import scalatags.Text.all._
import scalatags.Text.tags2

object Main extends App {
  object Conf extends ScallopConf(args) {
    val browser = opt[Boolean]()
    verify()
  }
  
  File("site").createIfNotExists(true)
  
  def at(url: String, content: String) = a(href := url, target := "_blank", content)
  
  val content = "<!DOCTYPE html>" + html(
    head(
      tags2.title("Pishen Tsai"),
      meta(charset := "UTF-8"),
      meta(name := "viewport", scalatags.Text.all.content := "width=device-width, initial-scale=1"),
      link(rel := "stylesheet", href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),
      raw(
        """
        <style>
          .container {
            max-width: 900px;
          }
          
          a:link,a:visited,a:hover,a:active {
            color: #333;
            text-decoration: underline;
          }
          
          h3 {
            font-size: 20px;
          }
          
          hr {
            margin-bottom: 0px;
          }
          
          ul {
            padding-left: 0px;
            list-style-type: square;
          }
          
          .label {
            color: #333;
            font-size: 15px;
            margin-right: 5px;
            margin-bottom: 5px;
            display: inline-block;
          }
          
          .label-default {
            background-color: #eee;
          }
        </style>
        """
      )
    ),
    body(
      div(
        cls := "container",
        marginTop := "30px",
        marginBottom := "30px",
        div(
          cls := "row",
          div(
            cls := "col-sm-9",
            fontSize := "40px",
            "Pishen Tsai"
          ),
          div(
            cls := "col-sm-3",
            div(height := "10px", cls := "hidden-xs"),
            at("https://github.com/pishen", "github.com/pishen"),
            br,
            a(href := "mailto:pishen02@gmail.com", "pishen02@gmail.com")
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Experience"))),
          div(
            cls := "col-sm-10",
            h3("Software Engineer at ", at("https://www.kktv.me", "KKTV"), br, small("Oct 2016 - Present")),
            ul(
              li("Improved the data engineering infrastructure. Used Scala/Spark to generate various reports, such as measuring users' satisfaction on each title, or computing the cost per view for each title.")
            ),
            h3("Software Engineer at ", at("https://www.kkbox.com", "KKBOX"), br, small("Oct 2014 - Sep 2016")),
            ul(
              li("Introduced the solutions of Scala/Spark into KKBOX. Helped training other 5+ engineers to use Scala/Spark in big data processing jobs, such as user log analytics or recommendation system."),
              li("Created tools like ", at("https://github.com/KKBOX/spark-deployer", "spark-deployer"), " in order to lower down the learning and maintaining burden of big data workflow."),
              li("Participated in the development of new recommendation system, including personalized feed, playlist generation, and radio system. Using machine learning tools like Google word2vec, Spark MLlib, and some speed-up indexing algorithms like Locality Sensitive Hashing or ", at("https://github.com/spotify/annoy", "spotify/annoy."), " Our new personalized feed has achieved 10% improvement in the CTR."),
              li("Developed an internal web application called \"KKRadio\", which can let a KKBOX user login, choose preference, and listen to an auto-generated radio playlist. The algorithm used to generate the radio can be plugged in easily for the QA and developers to compare the performance. A ", at("https://www.youtube.com/watch?v=haZftqgDsJo", "small demo"), " is available.")
            ),
            h3("Summer Intern at Yahoo! Taiwan", br, small("Jul 2013 - Aug 2013")),
            ul(
              li("Rewrote the Collaborative Filtering algorithm in the online Shopping Mall and achieved a 7x speed up (PoC)."),
              li("Demo the result on Yahoo! Taiwan's Intern Day and won the ", b("Most Popular Award."))
            ),
            h3("Graduate Student at IRLab, NTU", br, small("Sep 2011 - Jul 2014")),
            ul(
              li("Improved the accuracy of a speed-up algorithm for ", at("http://dl.acm.org/citation.cfm?id=2339643", "Logistic Markov Embedding"), ", which can be applied on predicting sequences like music playlist, online shopping flow, news reading...etc."),
              li("Slides: ", a(href := "soft-lme.pdf", "Modeling Item Sequences by Overlapped Markov Embeddings"))
            )
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Open Source"))),
          div(
            cls := "col-sm-10",
            h3(at("https://www.vocaradio.com/", "VocaRadio"), " ", small("← Click to Play")),
            ul(
              li("Github: ", at("https://github.com/pishen/vocaradio", "pishen/vocaradio")),
              li("A 24/7 web radio playing 1700+ VOCALOID songs on YouTube. Implemented by Play Framework and Akka Actors."),
              li("Since the current playing song is synchronized between each client, one can also use the websocket chatroom and song ordering system to interact with other fans.")
            ),
            h3(at("https://www.goi.moe/", "ゴイマシーン (goi machine)"), " ", small("← Click to Play")),
            ul(
              li("Github: ", at("https://github.com/pishen/goi", "pishen/goi")),
              li("A web application which helps users to learn Japanese vocabularies."),
              li("The system will memorize each answering attempt from the users, and use its cool-down algorithm to pick the next vocabulary for the user.")
            ),
            h3("sbt-emr-spark"),
            ul(
              li("Github: ", at("https://github.com/pishen/sbt-emr-spark", "pishen/sbt-emr-spark")),
              li("A SBT plugin which lets you run your Spark jobs on AWS EMR easily."),
              li("This project is a successor to ", at("https://github.com/KKBOX/spark-deployer", "KKBOX/spark-deployer"), ", which was widely adopted in KKBOX. Learned from the collected feedback, sbt-emr-spark has a simpler design and is even easier to use.")
            ),
            h3("chart4s"),
            ul(
              li("Github: ", at("https://github.com/pishen/chart4s", "pishen/chart4s")),
              li("A simple tool that lets you draw a web chart by Scala. Using typeclasses to keep the source code DRY.")
            ),
            h3("annoy4s"),
            ul(
              li("Github: ", at("https://github.com/pishen/annoy4s", "pishen/annoy4s")),
              li("A Scala client for ", at("https://github.com/spotify/annoy", "spotify/annoy."), " Using JNA (Java Native Access) to connect Scala to the C++ source code in Annoy.")
            ),
            h3("lsh4s"),
            ul(
              li("Github: ", at("https://github.com/pishen/lsh4s", "pishen/lsh4s")),
              li("A Scala implementation of Locality Sensitive Hashing, which was used in KKBOX's recommendation algorithm to speed up the indexing time on large vector space.")
            )
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Community"))),
          div(
            cls := "col-sm-10",
            h3("ScalaTaiwan ", small("Jan 2016 - Present")),
            p("A ", at("https://www.meetup.com/Scala-Taiwan-Meetup/", "meetup group"), " in Taipei which is held every month. I've joined in the very beginning and helped designing the logo and ", at("https://gitter.im/ScalaTaiwan/ScalaTaiwan", "gitter channel"), ". We are a group of people who loves to share knowledge and news about Scala, and would like to gather and strengthen the Scala community in Taiwan."),
            h3(at("http://scalakitchen.org/", "ScalaKitchen"), " ", small("← Click to Play")),
            p("A Chinese Scala tutorial with online playground, implemented by ", at("https://szeiger.github.io/ornate-doc/", "Ornate"), " site generator and ", at("https://scalafiddle.io/", "ScalaFiddle"), ". I'm now the main contributor of this project."),
            h3("Talks"),
            ul(
              li(b("ScalaKitchen"), " | ScalaTaiwan | 2017-04-12 | ", at("https://speakerdeck.com/pishen/scalakitchen", "slides")),
              li(b("sbt-emr-spark"), " | ScalaMatsuri 2017 Unconference | 2017-02-26 | ", at("https://speakerdeck.com/pishen/sbt-emr-spark", "slides")),
              li(b("My Personal Report of Scala Kansai 2016"), " | ScalaTaiwan | 2016-11-01 | ", at("https://speakerdeck.com/pishen/my-personal-report-of-scala-kansai-2016", "slides")),
              li(b("SBT Basic Concepts"), " | ScalaTaiwan | 2016-07-12 | ", at("https://speakerdeck.com/pishen/sbt-basic-concepts", "slides")),
              li(b("Deploy your own Spark cluster in 4 minutes using sbt"), " | JCConf 2015 | ", at("https://speakerdeck.com/pishen/deploy-your-own-spark-cluster-in-4-minutes-using-sbt", "slides"), " | ", at("https://www.youtube.com/watch?v=XWhQlhuBq2Q", "video"))
            )
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Skills"))),
          div(
            cls := "col-sm-10",
            marginTop := "20px",
            Seq("Scala", "Java", "JavaScript", "Python", "SQL", "HTML & CSS", "Apache Spark", "Play Framework", "Akka", "Amazon Web Service", "Machine Learning", "Emacs", "Ubuntu")
              .map(skill => span(cls := "label label-default", skill))
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Education"))),
          div(
            cls := "col-sm-10",
            h3("National Taiwan University", br, small("Sep 2011 - Jul 2014")),
            p("Master Computer Science. GPA 4.15"),
            h3("National Taiwan University", br, small("Sep 2007 - Jun 2011")),
            p("Bachelor Computer Science. Two presidential awards.")
          )
        ),
        hr,
        div(style := "margin: 20px 0;text-align:right", "This page is ", at("https://github.com/pishen/resume", "generated by Scala"))
      )
    )
  )
  
  val indexFile = File("site/index.html").overwrite(content)
  if(Conf.browser()) {
    Desktop.getDesktop.browse(indexFile.uri)
  }
}
