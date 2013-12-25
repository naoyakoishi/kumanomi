
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
object drinks extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Drink],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(drinks: List[Drink]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.23*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Drink list")/*5.20*/ {_display_(Seq[Any](format.raw/*5.22*/("""
    
    <h1>Drink Schedule List</h1>
    <div><a href="/drinks/new/">New Drink Schedule</a></div>
    
    <table border="1">
    	<tr>
    		<td>title</td>
    		<td>organizer</td>
    		<td>update time</td>
    		<td>process</td>
    	</tr>
        """),_display_(Seq[Any](/*17.10*/for(drink <- drinks) yield /*17.30*/ {_display_(Seq[Any](format.raw/*17.32*/("""
            <tr>
                <td><a href="/drink/"""),_display_(Seq[Any](/*19.38*/drink/*19.43*/.id)),format.raw/*19.46*/("""/">"""),_display_(Seq[Any](/*19.50*/drink/*19.55*/.title)),format.raw/*19.61*/("""</a></td>
                <td>"""),_display_(Seq[Any](/*20.22*/drink/*20.27*/.organizer)),format.raw/*20.37*/("""</td>
                <td>"""),_display_(Seq[Any](/*21.22*/drink/*21.27*/.updateAt.format("yyyy-MM-dd hh:mm"))),format.raw/*21.63*/("""</td>
                <td>
	                """),_display_(Seq[Any](/*23.19*/form(routes.DrinkController.deleteDrink(drink.id))/*23.69*/ {_display_(Seq[Any](format.raw/*23.71*/("""
	                    <input type="submit" value="Delete">
	                """)))})),format.raw/*25.19*/("""
                </td>
            </tr>
        """)))})),format.raw/*28.10*/("""
    </table>
""")))})))}
    }
    
    def render(drinks:List[Drink]): play.api.templates.HtmlFormat.Appendable = apply(drinks)
    
    def f:((List[Drink]) => play.api.templates.HtmlFormat.Appendable) = (drinks) => apply(drinks)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Oct 23 01:44:54 JST 2013
                    SOURCE: C:/play/workspace/kumanomi/app/views/drinks.scala.html
                    HASH: 90472c29d5b6b85c84d5d6ce18f4a68f68c504f6
                    MATRIX: 780->1|911->22|939->41|975->43|1001->61|1040->63|1330->317|1366->337|1406->339|1497->394|1511->399|1536->402|1576->406|1590->411|1618->417|1685->448|1699->453|1731->463|1794->490|1808->495|1866->531|1947->576|2006->626|2046->628|2155->705|2237->755
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|45->17|45->17|45->17|47->19|47->19|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|53->25|56->28
                    -- GENERATED --
                */
            