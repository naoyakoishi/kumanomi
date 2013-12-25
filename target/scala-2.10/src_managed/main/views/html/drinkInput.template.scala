
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
object drinkInput extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Drink],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(drinkForm: Form[Drink], users: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.47*/("""

"""),format.raw/*4.1*/("""
  """),_display_(Seq[Any](/*5.4*/main("New Drink")/*5.21*/ {_display_(Seq[Any](format.raw/*5.23*/("""
 　   """),_display_(Seq[Any](/*6.7*/form(routes.DrinkController.newDrink())/*6.46*/ {_display_(Seq[Any](format.raw/*6.48*/("""
    <div class="contentBody">
      <div class="contentTitle">飲み会の設定</div>
      <div class="content">
        """),_display_(Seq[Any](/*10.10*/inputText(drinkForm("title"), '_class -> "clm", '_label -> "飲み会"))),format.raw/*10.75*/(""" 
        """),_display_(Seq[Any](/*11.10*/textarea(drinkForm("description"), '_label -> "説明"))),format.raw/*11.61*/("""
        
        <div id="date">
          """),_display_(Seq[Any](/*14.12*/inputText(drinkForm("times[0].date"), 
          		'_label -> <span>候補日 <a href="" id="addDate">追加</a></span>))),format.raw/*15.72*/("""
        </div>
        
        <div id="shop">
　　　　　　　　　<dl>
            <dt>店  <a href="" id="addShop">追加</a></dt>
            <dd id="list">
                """),_display_(Seq[Any](/*22.18*/inputText(drinkForm("places[0].shopName"), '_class -> "clm", '_label -> "店名"))),format.raw/*22.95*/("""
    			"""),_display_(Seq[Any](/*23.9*/inputText(drinkForm("places[0].shopUrl"), '_class -> "clm", '_label -> "店URL"))),format.raw/*23.87*/("""
    			"""),_display_(Seq[Any](/*24.9*/inputText(drinkForm("places[0].station"), '_class -> "clm", '_label -> "最寄り駅"))),format.raw/*24.87*/("""
            </dd>
          </dl>
        </div>
          
        <div class="delimiter">
          <dl>
            <dt>memger</dt>
            <dd>
              <select multiple name="tmpUser">    
                """),_display_(Seq[Any](/*34.18*/for(user <- users) yield /*34.36*/ {_display_(Seq[Any](format.raw/*34.38*/("""
                  <option value='"""),_display_(Seq[Any](/*35.35*/user)),format.raw/*35.39*/("""'>"""),_display_(Seq[Any](/*35.42*/user)),format.raw/*35.46*/("""</option>
                """)))})),format.raw/*36.18*/("""
              </select>
            </dd>
          </dl>
        </div>
        <input type="submit" value="Create">
	  </div>
    </div>
  """)))})),format.raw/*44.4*/("""
""")))})),format.raw/*45.2*/("""
<a href=""""),_display_(Seq[Any](/*46.11*/routes/*46.17*/.DrinkController.drinks())),format.raw/*46.42*/("""">drinks</a>

<script>

var dateNum = 1;
var shopNum = 0;

$(document).ready(function() """),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""

	// 候補日 start
	$("#addDate").click(function() """),format.raw/*56.33*/("""{"""),format.raw/*56.34*/("""
		// テンプレート
		$tmpDate = $("div#tmpDate dd").clone();
		// idとnameを変更
		var id = $tmpDate.find("input").attr("id").replace("number", dateNum);
		$tmpDate.find("input").attr("id", id);
		$tmpDate.find("input").attr("name", $tmpDate.find("input").attr("name").replace("number", dateNum));
		// 削除リンク追加
		$tmpDate.append(createRemoveDateLink());
		$("div#date dl").append($tmpDate);
		
		$("#" + id).datepicker("""),format.raw/*67.26*/("""{"""),format.raw/*67.27*/("""
		    showOn: "both",
		    dateFormat: 'yy/mm/dd'
		"""),format.raw/*70.3*/("""}"""),format.raw/*70.4*/(""");
		dateNum ++;
		return false;
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
	
	function createRemoveDateLink() """),format.raw/*75.34*/("""{"""),format.raw/*75.35*/("""
		$removeDate = $("<a href='' id='removeDate'>削除</a>");
		$removeDate.click(function() """),format.raw/*77.32*/("""{"""),format.raw/*77.33*/("""
			$(this).parent("dd").remove();
			return false;
		"""),format.raw/*80.3*/("""}"""),format.raw/*80.4*/(""");
		return $removeDate;
	"""),format.raw/*82.2*/("""}"""),format.raw/*82.3*/("""
	
	$("#times_0__date").datepicker("""),format.raw/*84.33*/("""{"""),format.raw/*84.34*/("""
	    showOn: "both",
	    dateFormat: 'yy/mm/dd'
	"""),format.raw/*87.2*/("""}"""),format.raw/*87.3*/(""");

	$("#times_0__date").parent("dd").append(createRemoveDateLink());

	// 候補日 end

	//　店舗 start
	$("#addShop").click(function() """),format.raw/*94.33*/("""{"""),format.raw/*94.34*/("""
		$("div#shop").find("dd#list").append(createShopInput());
		return false;
	"""),format.raw/*97.2*/("""}"""),format.raw/*97.3*/(""");
	
	function createShopInput() """),format.raw/*99.29*/("""{"""),format.raw/*99.30*/("""
		$tmpShop = $(".tmpShop").clone();
		$tmpShop.attr("class", "shop");
		return $tmpShop;
	"""),format.raw/*103.2*/("""}"""),format.raw/*103.3*/("""
	
	//$("div#shop").find("dd#list").append(createShopInput());
	
	// 店舗　end
"""),format.raw/*108.1*/("""}"""),format.raw/*108.2*/(""");


</script>

<div class="hide">
  <div id="tmpDate">
    """),_display_(Seq[Any](/*115.6*/inputText(drinkForm("times[number].date")))),format.raw/*115.48*/("""
  </div>
  
  <div class="tmpShop">
    """),_display_(Seq[Any](/*119.6*/inputText(drinkForm("places[number].shopName"), '_class -> "clm", '_label -> "店名"))),format.raw/*119.88*/("""
    """),_display_(Seq[Any](/*120.6*/inputText(drinkForm("places[number].shopUrl"), '_class -> "clm", '_label -> "店URL"))),format.raw/*120.89*/("""
    """),_display_(Seq[Any](/*121.6*/inputText(drinkForm("places[number].station"), '_class -> "clm", '_label -> "最寄り駅"))),format.raw/*121.89*/("""
  </div>
</div>"""))}
    }
    
    def render(drinkForm:Form[Drink],users:List[String]): play.api.templates.HtmlFormat.Appendable = apply(drinkForm,users)
    
    def f:((Form[Drink],List[String]) => play.api.templates.HtmlFormat.Appendable) = (drinkForm,users) => apply(drinkForm,users)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 25 00:36:26 JST 2013
                    SOURCE: C:/play/workspace/kumanomi/app/views/drinkInput.scala.html
                    HASH: 59dcaa526ee036b2f618777cc0f114a757ab6cad
                    MATRIX: 797->1|952->46|980->65|1018->69|1043->86|1082->88|1123->95|1170->134|1209->136|1358->249|1445->314|1492->325|1565->376|1646->421|1778->531|1976->693|2075->770|2119->779|2219->857|2263->866|2363->944|2620->1165|2654->1183|2694->1185|2765->1220|2791->1224|2830->1227|2856->1231|2915->1258|3089->1401|3122->1403|3169->1414|3184->1420|3231->1445|3347->1533|3376->1534|3452->1582|3481->1583|3918->1992|3947->1993|4028->2047|4056->2048|4117->2082|4145->2083|4211->2121|4240->2122|4356->2210|4385->2211|4466->2265|4494->2266|4547->2292|4575->2293|4638->2328|4667->2329|4745->2380|4773->2381|4930->2510|4959->2511|5063->2588|5091->2589|5152->2622|5181->2623|5300->2714|5329->2715|5433->2791|5462->2792|5559->2853|5624->2895|5702->2937|5807->3019|5849->3025|5955->3108|5997->3114|6103->3197
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|34->6|34->6|34->6|38->10|38->10|39->11|39->11|42->14|43->15|50->22|50->22|51->23|51->23|52->24|52->24|62->34|62->34|62->34|63->35|63->35|63->35|63->35|64->36|72->44|73->45|74->46|74->46|74->46|81->53|81->53|84->56|84->56|95->67|95->67|98->70|98->70|101->73|101->73|103->75|103->75|105->77|105->77|108->80|108->80|110->82|110->82|112->84|112->84|115->87|115->87|122->94|122->94|125->97|125->97|127->99|127->99|131->103|131->103|136->108|136->108|143->115|143->115|147->119|147->119|148->120|148->120|149->121|149->121
                    -- GENERATED --
                */
            