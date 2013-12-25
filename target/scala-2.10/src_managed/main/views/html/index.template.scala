
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[User],Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(users: List[User], userForm: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.43*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Welcome to kumanomi")/*5.29*/ {_display_(Seq[Any](format.raw/*5.31*/("""
	<!--a href="http://www.facebook.com/dialog/oauth?client_id=456107231173835&redirect_uri=http%3A%2F%2Flocalhost%3A9000%2F">face book</a -->

	<div>users</div>
	<table>
	"""),_display_(Seq[Any](/*10.3*/for(user <- users) yield /*10.21*/ {_display_(Seq[Any](format.raw/*10.23*/("""
		<tr>
	    	<td>"""),_display_(Seq[Any](/*12.12*/user/*12.16*/.oauthType)),format.raw/*12.26*/("""</td>
	    	<td>"""),_display_(Seq[Any](/*13.12*/user/*13.16*/.openId)),format.raw/*13.23*/("""</td>
	    	<td>"""),_display_(Seq[Any](/*14.12*/user/*14.16*/.openId)),format.raw/*14.23*/("""</td>
	    	<td>
	    	"""),_display_(Seq[Any](/*16.8*/form(routes.Application.delete(user.id))/*16.48*/ {_display_(Seq[Any](format.raw/*16.50*/("""
	    		<input type="submit" value="Delete">
	    	""")))})),format.raw/*18.8*/("""
	    	</td>
		</tr>
	""")))})),format.raw/*21.3*/("""
	</table>
	
	"""),_display_(Seq[Any](/*24.3*/form(routes.Application.login())/*24.35*/ {_display_(Seq[Any](format.raw/*24.37*/("""
		"""),_display_(Seq[Any](/*25.4*/inputText(userForm("oauthType")))),format.raw/*25.36*/(""" 
		"""),_display_(Seq[Any](/*26.4*/inputText(userForm("openId")))),format.raw/*26.33*/(""" 
		<input type="submit" value="Create">
	""")))})),format.raw/*28.3*/("""
	
	<a href=""""),_display_(Seq[Any](/*30.12*/routes/*30.18*/.DrinkController.drinks())),format.raw/*30.43*/("""">drinks</a>
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(users:List[User],userForm:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(users,userForm)
    
    def f:((List[User],Form[User]) => play.api.templates.HtmlFormat.Appendable) = (users,userForm) => apply(users,userForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Oct 27 23:39:46 JST 2013
                    SOURCE: C:/play/workspace/kumanomi/app/views/index.scala.html
                    HASH: dc4a0243d247955905d45c470c4d7cc8b2946d8c
                    MATRIX: 789->1|940->42|968->61|1004->63|1039->90|1078->92|1284->263|1318->281|1358->283|1413->302|1426->306|1458->316|1511->333|1524->337|1553->344|1606->361|1619->365|1648->372|1707->396|1756->436|1796->438|1879->490|1933->513|1983->528|2024->560|2064->562|2103->566|2157->598|2197->603|2248->632|2322->675|2372->689|2387->695|2434->720|2479->734
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|44->16|44->16|44->16|46->18|49->21|52->24|52->24|52->24|53->25|53->25|54->26|54->26|56->28|58->30|58->30|58->30|59->31
                    -- GENERATED --
                */
            