// @SOURCE:C:/play/workspace/kumanomi/conf/routes
// @HASH:1def5cb300366ec23fd4fe09994627119c9ca215
// @DATE:Wed Oct 23 01:40:42 JST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseDrinkController {
    

// @LINE:13
def drinkInput(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "drinks/new/")
}
                                                

// @LINE:15
def deleteDrink(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "drinks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete/")
}
                                                

// @LINE:11
def drink(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "drink/" + implicitly[PathBindable[Long]].unbind("id", id) + "/")
}
                                                

// @LINE:14
def newDrink(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "drinks/new/")
}
                                                

// @LINE:12
def drinks(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "drinks/")
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def delete(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:7
def login(): Call = {
   Call("POST", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseDrinkController {
    

// @LINE:13
def drinkInput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DrinkController.drinkInput",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drinks/new/"})
      }
   """
)
                        

// @LINE:15
def deleteDrink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DrinkController.deleteDrink",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "drinks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete/"})
      }
   """
)
                        

// @LINE:11
def drink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DrinkController.drink",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drink/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/"})
      }
   """
)
                        

// @LINE:14
def newDrink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DrinkController.newDrink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "drinks/new/"})
      }
   """
)
                        

// @LINE:12
def drinks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DrinkController.drinks",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drinks/"})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseDrinkController {
    

// @LINE:13
def drinkInput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DrinkController.drinkInput(), HandlerDef(this, "controllers.DrinkController", "drinkInput", Seq(), "GET", """""", _prefix + """drinks/new/""")
)
                      

// @LINE:15
def deleteDrink(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DrinkController.deleteDrink(id), HandlerDef(this, "controllers.DrinkController", "deleteDrink", Seq(classOf[Long]), "POST", """""", _prefix + """drinks/$id<[^/]+>/delete/""")
)
                      

// @LINE:11
def drink(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DrinkController.drink(id), HandlerDef(this, "controllers.DrinkController", "drink", Seq(classOf[Long]), "GET", """ Drinks""", _prefix + """drink/$id<[^/]+>/""")
)
                      

// @LINE:14
def newDrink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DrinkController.newDrink(), HandlerDef(this, "controllers.DrinkController", "newDrink", Seq(), "POST", """""", _prefix + """drinks/new/""")
)
                      

// @LINE:12
def drinks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.DrinkController.drinks(), HandlerDef(this, "controllers.DrinkController", "drinks", Seq(), "GET", """""", _prefix + """drinks/""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long]), "POST", """""", _prefix + """$id<[^/]+>/delete""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "POST", """""", _prefix + """""")
)
                      
    
}
                          
}
        
    