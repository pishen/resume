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
            h3("Software Engineer at ", at("http://www.vpon.com/en/", "Vpon"), br, small("Oct 2017 - Present")),
            ul(
              li("Developed interactive insight reports for campaign managers to to find their target audience. Used Apache Spark and ", at("https://www.scala-js.org/", "Scala.js"), " to form a full-stack solution.")
            ),
            h3("Software Engineer at ", at("https://www.kktv.me", "KKTV"), br, small("Oct 2016 - Sep 2017")),
            ul(
              li("Created ", at("https://github.com/pishen/sbt-emr-spark", "sbt-emr-spark"), " and applied it on the data workflow in KKTV."),
              li("Developed a drama recommendation system based on Collaborative Filtering. This algorithm increased the average watching time by 1.5hr per week for each user.")
            ),
            h3("Software Engineer at ", at("https://www.kkbox.com/tw/en/index.html", "KKBOX"), br, small("Oct 2014 - Sep 2016")),
            ul(
              li("Introduced the solutions of Scala/Spark into KKBOX. Helped training other 5+ engineers to use Scala/Spark in big data processing jobs, such as user log analytics or recommendation system."),
              li("Created ", at("https://github.com/KKBOX/spark-deployer", "spark-deployer"), " to lower down the learning curve and maintenance cost of big data processing."),
              li("Participated in the development of recommendation system, including personalized feed and generated playlists. Used machine learning tools like Google word2vec and Spark MLlib. Our algorithm had improved the click rate on KKBOX's entry view by 20%."),
              li("Developed Approximate Nearest Neighbors indexing tools like ", at("https://github.com/pishen/lsh4s", "lsh4s"), " and ", at("https://github.com/annoy4s/annoy4s", "annoy4s"), " and applied them on the recommendation system."),
              li("Developed an internal web application called \"KKRadio\", which can let a KKBOX user login, choose preference, and listen to an auto-generated radio playlist. The playlist generating algorithm can be plugged in easily for the QA and developers to compare the performance. A ", at("https://www.youtube.com/watch?v=haZftqgDsJo", "small demo"), " is available.")
            ),
            h3("Summer Intern at Yahoo! Taiwan", br, small("Jul 2013 - Aug 2013")),
            ul(
              li("Rewrote the Collaborative Filtering algorithm in the online Shopping Mall and achieved a 7x speed up (PoC)."),
              li("Demo the result on Yahoo! Taiwan's Intern Day and won the Most Popular Award.")
            ),
            h3("Graduate Student at IRLab, NTU (Prof. Pu-Jen Cheng)", br, small("Sep 2011 - Jul 2014")),
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
            h3(at("https://vocaradio.com/", "VocaRadio")),
            ul(
              li("Github: ", at("https://github.com/pishen/vocaradio", "pishen/vocaradio")),
              li("A 24/7 web radio playing 1700+ VOCALOID songs on YouTube. Implemented by Play Framework and Akka Actors."),
              li("Since the current playing song is synchronized between each client, one can also use the websocket chatroom and song ordering system to interact with other fans.")
            ),
            h3(at("https://goi.moe/", "ゴイマシーン (goi machine)")),
            ul(
              li("Github: ", at("https://github.com/pishen/goi", "pishen/goi")),
              li("A web application which helps users to learn Japanese vocabularies."),
              li("The system will memorize each answering attempt from the users, and use its cool-down algorithm to pick the next vocabulary for the user.")
            ),
            h3("sbt-emr-spark"),
            ul(
              li("Github: ", at("https://github.com/pishen/sbt-emr-spark", "pishen/sbt-emr-spark")),
              li("A SBT plugin which lets you run your Spark jobs on AWS EMR easily."),
              li("This project is a successor to ", at("https://github.com/KKBOX/spark-deployer", "KKBOX/spark-deployer"), ", which was widely adopted in KKBOX. Learned from the collected feedback, sbt-emr-spark has a simpler design and is much more easier to use.")
            ),
            h3("scalikejdbc-generic"),
            ul(
              li("Github: ", at("https://github.com/pishen/scalikejdbc-generic", "pishen/scalikejdbc-generic")),
              li("A generic mapper which helps mapping your ScalikeJDBC's ResultSet into your custom data structure. Using ", at("https://github.com/milessabin/shapeless", "Shapeless"), " under the hood.")
            ),
            h3("annoy4s"),
            ul(
              li("Github: ", at("https://github.com/pishen/annoy4s", "pishen/annoy4s")),
              li("A Scala client for ", at("https://github.com/spotify/annoy", "spotify/annoy."), " Using JNA (Java Native Access) to connect Scala to the C++ source code in Annoy.")
            )
          )
        ),
        hr,
        div(
          cls := "row",
          div(cls := "col-sm-2", h3(i("Community"))),
          div(
            cls := "col-sm-10",
            h3(at("https://www.meetup.com/Scala-Taiwan-Meetup/", "ScalaTaiwan")),
            p("A meetup group in Taipei which has been held every month since Jan 2016. I've joined in the very beginning and helped the visual design and ", at("https://gitter.im/ScalaTaiwan/ScalaTaiwan", "gitter channel"), ". We are a group of people who loves to share knowledge and news about Scala, and would like to strengthen the Scala community in Taiwan."),
            h3(at("http://scalakitchen.org/", "ScalaKitchen")),
            p("A Chinese Scala tutorial with online playground, implemented by ", at("https://szeiger.github.io/ornate-doc/", "Ornate"), " and ", at("https://scalafiddle.io/", "ScalaFiddle"), ". I'm the creator and the first writer of this project."),
            h3("Talks"),
            ul(
              li(b("Shapeless Introduction"), " | ScalaTaiwan | 2017-07-12 | ", at("https://speakerdeck.com/pishen/shapeless-introduction", "slides")),
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
            Seq("Scala", "Java", "JavaScript", "Python", "HTML & CSS", "SQL", "Apache Spark", "Play Framework", "Akka", "Amazon Web Service", "Linux", "Emacs", "Machine Learning")
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
      ),
      raw("""
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

          ga('create', 'UA-44173601-3', 'auto');
          ga('send', 'pageview');

        </script>
      """)
    )
  )

  val indexFile = File("site/index.html").overwrite(content)
  if(Conf.browser()) {
    Desktop.getDesktop.browse(indexFile.uri)
  }
}
