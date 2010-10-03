

package bootstrap.liftweb

import _root_.net.liftweb.http.{LiftRules}
import _root_.net.liftweb.sitemap.{SiteMap, Menu, Loc}


class Boot {
  def boot {
  
  
    // where to search snippet
    LiftRules.addToPackages("eltimn")
                  
    LiftRules.setSiteMapFunc(MenuInfo.sitemap)

    // set character encoding
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    
    
  }
}

object MenuInfo {
  import Loc._

  def sitemap() = SiteMap(
    Menu("Home") / "index",
    Menu("Menus") / "menu" / "index" submenus(
      Menu("First Submenu") / "menu" / "one",
      Menu("Second Submenu (has more)") / "menu" / "two" submenus(
        Menu("First (2) Submenu") / "menu" / "two_one",
        Menu("Second (2) Submenu") / "menu" / "two_two"),
      Menu("Third Submenu") / "menu" / "three",
      Menu("Forth Submenu") / "menu" / "four")
  )
}
  