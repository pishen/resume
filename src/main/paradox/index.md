<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style>
header {
    display: none;
}

nav {
    display: none;
}

h1 {
    margin-top: 0;
}

.name {
    display: block;
    font-size: 0.5em;
}

.social a {
    color: #333333;
}

.company {
    display: block;
    font-size: smaller;
}

.duration {
    display: block;
    font-size: smaller;
    color: #808080;
}
</style>

# Pishen Tsai @span[蔡誠軒]{.name}
@@@ div { .social }
[<i class="bi bi-envelope"></i>](mailto:pishen02@gmail.com) |
[<i class="bi bi-github"></i>](https://github.com/pishen) |
[<i class="bi bi-linkedin"></i>](https://www.linkedin.com/in/pishen) |
[<i class="bi bi-facebook"></i>](https://www.facebook.com/pishen) |
[<i class="bi bi-twitter"></i>](https://twitter.com/pishen)
@@@

## Experience

### Senior Software Engineer @span[[Atgenomix](https://www.atgenomix.com/)]{.company} @span[Dec 2023 - Apr 2024]{.duration}

* Develope new backends of [Cromwell](https://github.com/broadinstitute/cromwell) for it to run on different cloud platforms using Spark on Kubernetes.

### Senior Data Engineer @span[[Vpon Big Data Group](https://www.vpon.com/)]{.company} @span[Oct 2017 - Nov 2023]{.duration}

* Designed and developed the backend of [Wee Data Platform](https://wee.vpon.com/). This platform utilizes [Scio](https://spotify.github.io/scio/) to process data sources, stores the results in Google Cloud Datastore, and offers content of 13 distinct dashboards/functions through an App Engine API server implemented by [Tapir](https://tapir.softwaremill.com/) and Akka HTTP.
* Rolled out a GitHub development workflow in the backend team, with a CI/CD process implemented by GitHub Actions and SBT.
* Developed a large-scale geodata encoding algorithm utilizing [GeoTrellis](https://geotrellis.io/) and Scio. The algorithm samples and encodes geodata into [vector tiles](https://www.maptiler.com/google-maps-coordinates-tile-bounds-projection), providing a smooth map browsing experience.
* Created [store4s](https://github.com/pishen/store4s) to eliminate the boilerplate and introduce type-safety during interactions with Google Cloud Datastore.
* Built a web application that uses a lookalike algorithm to find potential users for a specific app on Google Play. This application is implemented by Scio, Akka HTTP, and Scala.js.

### Software Engineer @span[[KKTV](https://www.kktv.me/)]{.company} @span[Oct 2016 - Sep 2017]{.duration}

* Created [sbt-lighter](https://github.com/pishen/sbt-lighter) and applied it to the data workflow in KKTV.
* Developed a drama recommendation system based on Collaborative Filtering. This algorithm increased the average watching time by 1.5 hours per week for each user.

### Software Engineer @span[[KKBOX](https://www.kkbox.com/)]{.company} @span[Oct 2014 - Sep 2016]{.duration}

* Introduced the solutions of Scala/Spark into KKBOX. Helped train other 5 engineers to use Scala/Spark in big data processing jobs, such as user log analytics or recommendation systems.
* Created [spark-deployer](https://github.com/KKBOX/spark-deployer) to lower the learning curve and maintenance cost of big data processing.
* Participated in the development of a recommendation system, including personalized feed and generated playlists. Used machine learning tools like Google word2vec and Spark MLlib. Our algorithm improved the click rate on KKBOX's entry view by 20%.
* Created Approximate Nearest Neighbors indexing tools like [lsh4s](https://github.com/pishen/lsh4s) and [annoy4s](https://github.com/annoy4s/annoy4s) and applied them to the recommendation system.
* Built an internal web application called "KKRadio", which can let a KKBOX user log in, choose a preference, and listen to an auto-generated radio playlist. The playlist-generating algorithm can be plugged in easily for the QA and developers to compare the performance. A [small demo](https://www.youtube.com/watch?v=haZftqgDsJo) is available.

### Summer Intern @span[[Yahoo! Taiwan](https://tw.yahoo.com/)]{.company} @span[Jul 2013 - Aug 2013]{.duration}

* Rewrote the Collaborative Filtering algorithm in the online Shopping Mall and achieved a 7x speed up (PoC).
* Demo the result on Yahoo! Taiwan's Intern Day and won the Most Popular Award.

## Projects

### [store4s](https://github.com/pishen/store4s)
A Scala client for [Google Cloud Datastore](https://cloud.google.com/datastore/docs). Using Shapeless to provide a compile-time mapping between case classes and Datastore entities, Scala macros to provide a type-safe query DSL, and [sttp](https://sttp.softwaremill.com/) to provide an asynchronous interface.

### [bql](https://github.com/pishen/bql)
A Scala library that builds BigQuery SQL with Scala String interpolation. By using this technique, we can prevent SQL injection when putting variables into a SQL string.

### [annoy4s](https://github.com/annoy4s/annoy4s)
A JNA wrapper of Spotify [annoy](https://github.com/spotify/annoy) which calls the C++ library directly from Scala/JVM. This library is also included by Spotify [Scio](https://spotify.github.io/scio/).

### [minitime](https://github.com/pishen/minitime)
A Scala/Scala.js library which operates on time and dates with `+`, `-`, `*`, `/`, `>`, `<`, `to`, and more. This library uses a typeclass design so you can extend the supports to your own time and date classes easily.

### [sbt-lighter](https://github.com/pishen/sbt-lighter)
A SBT plugin that lets you create [Spark cluster on AWS EMR](https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-spark-launch.html) and submit jobs to it. Providing a one-click user experience from jar assembly, cluster creation, and submitting jobs, to finally terminate the cluster.

### [akka-ui](https://github.com/pishen/akka-ui)
A Scala.js library that uses Akka Streams in Akka.js to build a reactive UI.

## Community

### [ScalaTaiwan](https://www.meetup.com/Scala-Taiwan-Meetup/)
A meetup group in Taipei which was founded in Jan 2016. As one of the founders, I have been involved in visual design and the management of the Facebook group. Our community consists of people who are passionate about sharing knowledge and updates related to Scala. We aim to foster and enhance the Scala community in Taiwan.

### Talks
* Introduction to Minitime | ScalaTaiwan | 2019-09-09 | [slides](https://speakerdeck.com/pishen/introduction-to-minitime)
* 都什麼時代了，你還在寫 while loop 嗎？ | JCConf 2018 | [video](https://www.youtube.com/watch?v=6fHE9Xu7DUw)
* Scala + Google Dataflow = Serverless Spark | ScalaTaiwan | 2018-06-21 | [slides](https://speakerdeck.com/pishen/scala-plus-google-dataflow-equals-serverless-spark)
* Shapeless Introduction | ScalaTaiwan | 2017-07-12 | [slides](https://speakerdeck.com/pishen/shapeless-introduction)
* ScalaKitchen | ScalaTaiwan | 2017-04-12 | [slides](https://speakerdeck.com/pishen/scalakitchen)
* sbt-lighter | ScalaMatsuri 2017 Unconference | 2017-02-26 | [slides](https://speakerdeck.com/pishen/sbt-emr-spark)
* My Personal Report of Scala Kansai 2016 | ScalaTaiwan | 2016-11-01 | [slides](https://speakerdeck.com/pishen/my-personal-report-of-scala-kansai-2016)
* SBT Basic Concepts | ScalaTaiwan | 2016-07-12 | [slides](https://speakerdeck.com/pishen/sbt-basic-concepts)
* Deploy your own Spark cluster in 4 minutes using sbt | JCConf 2015 | [slides](https://speakerdeck.com/pishen/deploy-your-own-spark-cluster-in-4-minutes-using-sbt) | [video](https://www.youtube.com/watch?v=XWhQlhuBq2Q)

## Skills
Scala | Java | Python | JavaScript | SQL | HTML & CSS | Tapir | Cats | Akka | Google Cloud Dataflow | Apache Spark | Kubernetes | GCP | AWS | Linux | VScode | Machine Learning

## Education

### National Taiwan University @span[Master, Computer Science & Information Engineering]{.company} @span[2011 - 2014]{.duration}
GPA 4.15

### National Taiwan University @span[Bachelor, Computer Science & Information Engineering]{.company} @span[2007 - 2011]{.duration}
Two presidential awards.
