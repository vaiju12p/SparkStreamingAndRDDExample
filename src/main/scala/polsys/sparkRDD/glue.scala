package polsys.sparkRDD

import org.apache.spark.sql.SaveMode

import scala.io.Source
/**
  * Created by vaijnathp on 3/26/2018.
  */
object glue {

 /* def main(args: Array[String]): Unit = {
    glueCall("C:\\Users\\vaijnathp\\Desktop\\T.csv","asdf")

  }*/

def glueCall(src: String , tgt: String): Unit ={
  val spark = org.apache.spark.sql.SparkSession.builder
    .master("local")
    .appName("Spark CSV Reader")
    .getOrCreate;





  val df=spark.read.text("s3://engine.hydrograph.bitwiseglobal/testData/part-00000-6c5cfd42-f238-4fd8-81ad-bb15fa70b730.csv")

  df.write.mode(SaveMode.Overwrite)
    .text(tgt)
}

}
