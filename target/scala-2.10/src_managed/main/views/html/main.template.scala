
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/jquery-ui-1.10.3.custom.min.css"))),format.raw/*9.117*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.10.2.min.js"))),format.raw/*11.75*/("""" type="text/javascript"></script>
    	<script src=""""),_display_(Seq[Any](/*12.20*/routes/*12.26*/.Assets.at("javascripts/jquery-ui-1.10.3.custom.min.js"))),format.raw/*12.82*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(Seq[Any](/*15.10*/content)),format.raw/*15.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Oct 26 12:12:47 JST 2013
                    SOURCE: C:/play/workspace/kumanomi/app/views/main.scala.html
                    HASH: 1c01966c75dedac5c32da742a0476219b1a77ce1
                    MATRIX: 778->1|902->31|990->84|1016->89|1113->151|1127->157|1182->191|1273->247|1287->253|1366->310|1463->371|1478->377|1532->409|1593->434|1608->440|1676->486|1766->540|1781->546|1859->602|1962->669|1991->676
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|43->15|43->15
                    -- GENERATED --
                */
            