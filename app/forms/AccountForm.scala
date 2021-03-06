package forms

import java.util.Date
import play.api.data.Form
import play.api.data.Forms._
import models.TablesExtend._
import play.api.data.validation.Constraints._
import play.api.i18n.{I18nSupport, MessagesApi, Messages, Lang}
import javax.inject.Inject
import utilities._

class AccountForm @Inject()(val messagesApi: MessagesApi) extends I18nSupport{
    val formnew = Form(
    mapping(
      "id" -> optional(number),
      "email" -> text.verifying(ValidationHelper.emailAddress),
      "password" -> text.verifying(Messages("error.required", "パスワード"), {!_.isEmpty})
                                  .verifying(Messages("error.maxLength", 10),{_.length <= 50 })
                            .verifying(Messages("error.minLength", 4),{_.length >=4}),
      "name" -> text.verifying(Messages("error.required", "名前"), {!_.isEmpty})
                            .verifying(Messages("error.maxLength", 10),{_.length <= 50 })
                            .verifying(Messages("error.minLength", 4),{_.length >=4}),
      "role" -> text.verifying(Messages("error.maxLength", 10),{_.length <= 50 })

      )
      (accountapply)(accountunapply)
  )
    val formedit = Form(
    mapping(
      "id" -> optional(number),
      "email" -> email,
      "password" -> text.verifying(Messages("error.maxLength", 10),{_.length <= 50 })
                            .verifying(Messages("error.minLength", 4),{e => e.isEmpty || e.length >=4}),
      "name" -> text.verifying(Messages("error.required", "名前"), {!_.isEmpty})
                            .verifying(Messages("error.maxLength", 10),{_.length <= 50 })
                            .verifying(Messages("error.minLength", 4),{_.length >=4}),
      "role" -> text.verifying(Messages("error.maxLength", 10),{_.length <= 50 })

      )
      (accountapply)(accountunapply)
  )
  private def accountapply(
      id: Option[Int],
      email:  String,
      password:  String,
      name: String, 
      role: String
       ) = new AccountRow(id.getOrElse(0), email, password, name, role)
  private def accountunapply(n: AccountRow) = Some(
      (Option(n.id), n.email, n.password, n.name, n.role)
      )

}