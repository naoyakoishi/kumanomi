
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
object drink extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Drink,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(drink: Drink):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Drink Schedule")/*5.24*/ {_display_(Seq[Any](format.raw/*5.26*/("""
    
    <h1>"""),_display_(Seq[Any](/*7.10*/drink/*7.15*/.title)),format.raw/*7.21*/("""</h1>
    
    <div>"""),_display_(Seq[Any](/*9.11*/drink/*9.16*/.description)),format.raw/*9.28*/("""</div>

	<div>information</div>
    <table border="1">
	<tr>
		<td>organizer</td>
		<td>"""),_display_(Seq[Any](/*15.8*/drink/*15.13*/.organizer)),format.raw/*15.23*/("""</td>
	</tr>
		<tr>
		<td>update time</td>
		<td>"""),_display_(Seq[Any](/*19.8*/drink/*19.13*/.updateAt)),format.raw/*19.22*/("""</td>
	</tr>
	</table>

	<div>time</div>
	<table border="1">
	"""),_display_(Seq[Any](/*25.3*/for(time <- drink.times) yield /*25.27*/ {_display_(Seq[Any](format.raw/*25.29*/("""
		<tr>
			<td>"""),_display_(Seq[Any](/*27.9*/time/*27.13*/.date.format("yyyy/MM/dd"))),format.raw/*27.39*/("""</td>
		</tr>
	
	""")))})),format.raw/*30.3*/("""
	</table>
	
	<div>place</div>
	<table border="1">
	"""),_display_(Seq[Any](/*35.3*/for(place <- drink.places) yield /*35.29*/ {_display_(Seq[Any](format.raw/*35.31*/("""
		<tr>
			<td><a href=""""),_display_(Seq[Any](/*37.18*/place/*37.23*/.shopUrl)),format.raw/*37.31*/("""">"""),_display_(Seq[Any](/*37.34*/place/*37.39*/.shopName)),format.raw/*37.48*/("""</a></td>
			<td>"""),_display_(Seq[Any](/*38.9*/place/*38.14*/.station)),format.raw/*38.22*/("""</td>
		</tr>
	""")))})),format.raw/*40.3*/("""
	</table>
	
	<div>user</div>
	<table border="1">
	"""),_display_(Seq[Any](/*45.3*/for(user <- drink.users) yield /*45.27*/ {_display_(Seq[Any](format.raw/*45.29*/("""
		<tr>
			<td>"""),_display_(Seq[Any](/*47.9*/user/*47.13*/.name)),format.raw/*47.18*/("""</td>
		</tr>
	""")))})),format.raw/*49.3*/("""
	</table>
	
	<a href=""""),_display_(Seq[Any](/*52.12*/routes/*52.18*/.DrinkController.drinks())),format.raw/*52.43*/("""">drinks</a>
""")))})))}
    }
    
    def render(drink:Drink): play.api.templates.HtmlFormat.Appendable = apply(drink)
    
    def f:((Drink) => play.api.templates.HtmlFormat.Appendable) = (drink) => apply(drink)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 23 11:08:37 JST 2013
                    SOURCE: C:/play/workspace/kumanomi/app/views/drink.scala.html
                    HASH: 37513ca0e4c2284ac36d1d70c40bb8c09b66f772
                    MATRIX: 773->1|897->15|925->34|961->36|991->58|1030->60|1080->75|1093->80|1120->86|1176->107|1189->112|1222->124|1346->213|1360->218|1392->228|1477->278|1491->283|1522->292|1620->355|1660->379|1700->381|1751->397|1764->401|1812->427|1861->445|1949->498|1991->524|2031->526|2092->551|2106->556|2136->564|2175->567|2189->572|2220->581|2273->599|2287->604|2317->612|2364->628|2451->680|2491->704|2531->706|2582->722|2595->726|2622->731|2669->747|2729->771|2744->777|2791->802
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|43->15|43->15|43->15|47->19|47->19|47->19|53->25|53->25|53->25|55->27|55->27|55->27|58->30|63->35|63->35|63->35|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|75->47|75->47|77->49|80->52|80->52|80->52
                    -- GENERATED --
                */
            