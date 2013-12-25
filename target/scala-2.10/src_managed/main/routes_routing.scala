// @SOURCE:C:/play/workspace/kumanomi/conf/routes
// @HASH:1def5cb300366ec23fd4fe09994627119c9ca215
// @DATE:Wed Oct 23 01:40:42 JST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_login1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_delete2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
        

// @LINE:11
private[this] lazy val controllers_DrinkController_drink3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drink/"),DynamicPart("id", """[^/]+""",true),StaticPart("/"))))
        

// @LINE:12
private[this] lazy val controllers_DrinkController_drinks4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drinks/"))))
        

// @LINE:13
private[this] lazy val controllers_DrinkController_drinkInput5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drinks/new/"))))
        

// @LINE:14
private[this] lazy val controllers_DrinkController_newDrink6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drinks/new/"))))
        

// @LINE:15
private[this] lazy val controllers_DrinkController_deleteDrink7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("drinks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete/"))))
        

// @LINE:18
private[this] lazy val controllers_Assets_at8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix,"""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$id<[^/]+>/delete""","""controllers.Application.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drink/$id<[^/]+>/""","""controllers.DrinkController.drink(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drinks/""","""controllers.DrinkController.drinks()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drinks/new/""","""controllers.DrinkController.drinkInput()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drinks/new/""","""controllers.DrinkController.newDrink()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """drinks/$id<[^/]+>/delete/""","""controllers.DrinkController.deleteDrink(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_delete2(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """$id<[^/]+>/delete"""))
   }
}
        

// @LINE:11
case controllers_DrinkController_drink3(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.DrinkController.drink(id), HandlerDef(this, "controllers.DrinkController", "drink", Seq(classOf[Long]),"GET", """ Drinks""", Routes.prefix + """drink/$id<[^/]+>/"""))
   }
}
        

// @LINE:12
case controllers_DrinkController_drinks4(params) => {
   call { 
        invokeHandler(controllers.DrinkController.drinks(), HandlerDef(this, "controllers.DrinkController", "drinks", Nil,"GET", """""", Routes.prefix + """drinks/"""))
   }
}
        

// @LINE:13
case controllers_DrinkController_drinkInput5(params) => {
   call { 
        invokeHandler(controllers.DrinkController.drinkInput(), HandlerDef(this, "controllers.DrinkController", "drinkInput", Nil,"GET", """""", Routes.prefix + """drinks/new/"""))
   }
}
        

// @LINE:14
case controllers_DrinkController_newDrink6(params) => {
   call { 
        invokeHandler(controllers.DrinkController.newDrink(), HandlerDef(this, "controllers.DrinkController", "newDrink", Nil,"POST", """""", Routes.prefix + """drinks/new/"""))
   }
}
        

// @LINE:15
case controllers_DrinkController_deleteDrink7(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.DrinkController.deleteDrink(id), HandlerDef(this, "controllers.DrinkController", "deleteDrink", Seq(classOf[Long]),"POST", """""", Routes.prefix + """drinks/$id<[^/]+>/delete/"""))
   }
}
        

// @LINE:18
case controllers_Assets_at8(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     