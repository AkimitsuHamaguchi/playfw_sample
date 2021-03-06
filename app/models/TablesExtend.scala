package models

import java.sql.Timestamp
import java.util.Date
import java.util.UUID

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object TablesExtend extends {
  val profile = slick.driver.MySQLDriver
} with TablesExtend

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait TablesExtend {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  
  implicit def javaDateMapper = MappedColumnType.base[Date, Timestamp](
      dt => new Timestamp(dt.getTime),
      ts => new Date(ts.getTime)
  )
  
  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AccessToken.schema, Account.schema, AuthCode.schema, Bill.schema, Contract.schema, Customer.schema, OauthClient.schema, OauthUser.schema, PlayEvolutions.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AccessToken
   *  @param accessToken Database column access_token SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param refreshToken Database column refresh_token SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userGuid Database column user_guid SqlType(BINARY)
   *  @param oauthClientId Database column oauth_client_id SqlType(BINARY)
   *  @param redirectUri Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(INT)
   *  @param createdDate Database column created_date SqlType(DATETIME) */
  case class AccessTokenRow(accessToken: String, refreshToken: Option[String] = None, userGuid: UUID, oauthClientId: UUID, redirectUri: Option[String] = None, scope: Option[String] = None, expiresIn: Int, createdDate: Date)
  /** GetResult implicit for fetching AccessTokenRow objects using plain SQL queries */
  implicit def GetResultAccessTokenRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[UUID], e3: GR[Int], e4: GR[Date]): GR[AccessTokenRow] = GR{
    prs => import prs._
    AccessTokenRow.tupled((<<[String], <<?[String], <<[UUID], <<[UUID], <<?[String], <<?[String], <<[Int], <<[Date]))
  }
  /** Table description of table access_token. Objects of this class serve as prototypes for rows in queries. */
  class AccessToken(_tableTag: Tag) extends Table[AccessTokenRow](_tableTag, "access_token") {
    def * = (accessToken, refreshToken, userGuid, oauthClientId, redirectUri, scope, expiresIn, createdDate) <> (AccessTokenRow.tupled, AccessTokenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(accessToken), refreshToken, Rep.Some(userGuid), Rep.Some(oauthClientId), redirectUri, scope, Rep.Some(expiresIn), Rep.Some(createdDate)).shaped.<>({r=>import r._; _1.map(_=> AccessTokenRow.tupled((_1.get, _2, _3.get, _4.get, _5, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column access_token SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val accessToken: Rep[String] = column[String]("access_token", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column refresh_token SqlType(VARCHAR), Length(255,true), Default(None) */
    val refreshToken: Rep[Option[String]] = column[Option[String]]("refresh_token", O.Length(255,varying=true), O.Default(None))
    /** Database column user_guid SqlType(BINARY) */
    val userGuid: Rep[UUID] = column[UUID]("user_guid")
    /** Database column oauth_client_id SqlType(BINARY) */
    val oauthClientId: Rep[UUID] = column[UUID]("oauth_client_id")
    /** Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("redirect_uri", O.Length(255,varying=true), O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(255,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(255,varying=true), O.Default(None))
    /** Database column expires_in SqlType(INT) */
    val expiresIn: Rep[Int] = column[Int]("expires_in")
    /** Database column created_date SqlType(DATETIME) */
    val createdDate: Rep[Date] = column[Date]("created_date")
  }
  /** Collection-like TableQuery object for table AccessToken */
  lazy val AccessToken = new TableQuery(tag => new AccessToken(tag))

  /** Entity class storing rows of table Account
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param email Database column email SqlType(VARCHAR), Length(255,true)
   *  @param password Database column password SqlType(VARCHAR), Length(255,true)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param role Database column role SqlType(VARCHAR), Length(255,true) */
  case class AccountRow(id: Int, email: String, password: String, name: String, role: String)
  /** GetResult implicit for fetching AccountRow objects using plain SQL queries */
  implicit def GetResultAccountRow(implicit e0: GR[Int], e1: GR[String]): GR[AccountRow] = GR{
    prs => import prs._
    AccountRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table account. Objects of this class serve as prototypes for rows in queries. */
  class Account(_tableTag: Tag) extends Table[AccountRow](_tableTag, "account") {
    def * = (id, email, password, name, role) <> (AccountRow.tupled, AccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(email), Rep.Some(password), Rep.Some(name), Rep.Some(role)).shaped.<>({r=>import r._; _1.map(_=> AccountRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(VARCHAR), Length(255,true) */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true))
    /** Database column password SqlType(VARCHAR), Length(255,true) */
    val password: Rep[String] = column[String]("password", O.Length(255,varying=true))
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column role SqlType(VARCHAR), Length(255,true) */
    val role: Rep[String] = column[String]("role", O.Length(255,varying=true))

    /** Uniqueness Index over (email) (database name email) */
    val index1 = index("email", email, unique=true)
  }
  /** Collection-like TableQuery object for table Account */
  lazy val Account = new TableQuery(tag => new Account(tag))

  /** Entity class storing rows of table AuthCode
   *  @param authorizationCode Database column authorization_code SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param userGuid Database column user_guid SqlType(BINARY)
   *  @param oauthClientId Database column oauth_client_id SqlType(BINARY)
   *  @param redirectUri Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(INT)
   *  @param createdDate Database column created_date SqlType(DATETIME) */
  case class AuthCodeRow(authorizationCode: String, userGuid: UUID, oauthClientId: UUID, redirectUri: Option[String] = None, scope: Option[String] = None, expiresIn: Int, createdDate: Date)
  /** GetResult implicit for fetching AuthCodeRow objects using plain SQL queries */
  implicit def GetResultAuthCodeRow(implicit e0: GR[String], e1: GR[UUID], e2: GR[Option[String]], e3: GR[Int], e4: GR[Date]): GR[AuthCodeRow] = GR{
    prs => import prs._
    AuthCodeRow.tupled((<<[String], <<[UUID], <<[UUID], <<?[String], <<?[String], <<[Int], <<[Date]))
  }
  /** Table description of table auth_code. Objects of this class serve as prototypes for rows in queries. */
  class AuthCode(_tableTag: Tag) extends Table[AuthCodeRow](_tableTag, "auth_code") {
    def * = (authorizationCode, userGuid, oauthClientId, redirectUri, scope, expiresIn, createdDate) <> (AuthCodeRow.tupled, AuthCodeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(authorizationCode), Rep.Some(userGuid), Rep.Some(oauthClientId), redirectUri, scope, Rep.Some(expiresIn), Rep.Some(createdDate)).shaped.<>({r=>import r._; _1.map(_=> AuthCodeRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column authorization_code SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val authorizationCode: Rep[String] = column[String]("authorization_code", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column user_guid SqlType(BINARY) */
    val userGuid: Rep[UUID] = column[UUID]("user_guid")
    /** Database column oauth_client_id SqlType(BINARY) */
    val oauthClientId: Rep[UUID] = column[UUID]("oauth_client_id")
    /** Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("redirect_uri", O.Length(255,varying=true), O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(255,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(255,varying=true), O.Default(None))
    /** Database column expires_in SqlType(INT) */
    val expiresIn: Rep[Int] = column[Int]("expires_in")
    /** Database column created_date SqlType(DATETIME) */
    val createdDate: Rep[Date] = column[Date]("created_date")
  }
  /** Collection-like TableQuery object for table AuthCode */
  lazy val AuthCode = new TableQuery(tag => new AuthCode(tag))

  /** Entity class storing rows of table Bill
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param contractId Database column contract_id SqlType(BIGINT)
   *  @param billName Database column bill_name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param billEmail Database column bill_email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param billTel Database column bill_tel SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param billAddress Database column bill_address SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdDate Database column created_date SqlType(DATETIME), Default(None)
   *  @param updatedDate Database column updated_date SqlType(TIMESTAMP) */
  case class BillRow(id: Long, contractId: Long, billName: Option[String] = None, billEmail: Option[String] = None, billTel: Option[String] = None, billAddress: Option[String] = None, createdDate: Option[Date] = None, updatedDate: Date)
  /** GetResult implicit for fetching BillRow objects using plain SQL queries */
  implicit def GetResultBillRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Date]], e3: GR[Date]): GR[BillRow] = GR{
    prs => import prs._
    BillRow.tupled((<<[Long], <<[Long], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Date], <<[Date]))
  }
  /** Table description of table bill. Objects of this class serve as prototypes for rows in queries. */
  class Bill(_tableTag: Tag) extends Table[BillRow](_tableTag, "bill") {
    def * = (id, contractId, billName, billEmail, billTel, billAddress, createdDate, updatedDate) <> (BillRow.tupled, BillRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(contractId), billName, billEmail, billTel, billAddress, createdDate, Rep.Some(updatedDate)).shaped.<>({r=>import r._; _1.map(_=> BillRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column contract_id SqlType(BIGINT) */
    val contractId: Rep[Long] = column[Long]("contract_id")
    /** Database column bill_name SqlType(VARCHAR), Length(255,true), Default(None) */
    val billName: Rep[Option[String]] = column[Option[String]]("bill_name", O.Length(255,varying=true), O.Default(None))
    /** Database column bill_email SqlType(VARCHAR), Length(255,true), Default(None) */
    val billEmail: Rep[Option[String]] = column[Option[String]]("bill_email", O.Length(255,varying=true), O.Default(None))
    /** Database column bill_tel SqlType(VARCHAR), Length(255,true), Default(None) */
    val billTel: Rep[Option[String]] = column[Option[String]]("bill_tel", O.Length(255,varying=true), O.Default(None))
    /** Database column bill_address SqlType(VARCHAR), Length(255,true), Default(None) */
    val billAddress: Rep[Option[String]] = column[Option[String]]("bill_address", O.Length(255,varying=true), O.Default(None))
    /** Database column created_date SqlType(DATETIME), Default(None) */
    val createdDate: Rep[Option[Date]] = column[Option[Date]]("created_date", O.Default(None))
    /** Database column updated_date SqlType(TIMESTAMP) */
    val updatedDate: Rep[Date] = column[Date]("updated_date")
  }
  /** Collection-like TableQuery object for table Bill */
  lazy val Bill = new TableQuery(tag => new Bill(tag))

  /** Entity class storing rows of table Contract
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param customerId Database column customer_id SqlType(BIGINT)
   *  @param status Database column status SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param comment Database column comment SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param contractDate Database column contract_date SqlType(DATETIME), Default(None)
   *  @param cancelDate Database column cancel_date SqlType(DATETIME), Default(None)
   *  @param isDisabled Database column is_disabled SqlType(TINYINT), Default(None)
   *  @param createdDate Database column created_date SqlType(DATETIME), Default(None)
   *  @param updatedDate Database column updated_date SqlType(TIMESTAMP) */
  case class ContractRow(id: Long, customerId: Long, status: Option[String] = None, comment: Option[String] = None, contractDate: Option[Date] = None, cancelDate: Option[Date] = None, isDisabled: Option[Boolean] = None, createdDate: Option[Date] = None, updatedDate: Date)
  /** GetResult implicit for fetching ContractRow objects using plain SQL queries */
  implicit def GetResultContractRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Date]], e3: GR[Option[Boolean]], e4: GR[Date]): GR[ContractRow] = GR{
    prs => import prs._
    ContractRow.tupled((<<[Long], <<[Long], <<?[String], <<?[String], <<?[Date], <<?[Date], <<?[Boolean], <<?[Date], <<[Date]))
  }
  /** Table description of table contract. Objects of this class serve as prototypes for rows in queries. */
  class Contract(_tableTag: Tag) extends Table[ContractRow](_tableTag, "contract") {
    def * = (id, customerId, status, comment, contractDate, cancelDate, isDisabled, createdDate, updatedDate) <> (ContractRow.tupled, ContractRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(customerId), status, comment, contractDate, cancelDate, isDisabled, createdDate, Rep.Some(updatedDate)).shaped.<>({r=>import r._; _1.map(_=> ContractRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column customer_id SqlType(BIGINT) */
    val customerId: Rep[Long] = column[Long]("customer_id")
    /** Database column status SqlType(VARCHAR), Length(50,true), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Length(50,varying=true), O.Default(None))
    /** Database column comment SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val comment: Rep[Option[String]] = column[Option[String]]("comment", O.Length(16777215,varying=true), O.Default(None))
    /** Database column contract_date SqlType(DATETIME), Default(None) */
    val contractDate: Rep[Option[Date]] = column[Option[Date]]("contract_date", O.Default(None))
    /** Database column cancel_date SqlType(DATETIME), Default(None) */
    val cancelDate: Rep[Option[Date]] = column[Option[Date]]("cancel_date", O.Default(None))
    /** Database column is_disabled SqlType(TINYINT), Default(None) */
    val isDisabled: Rep[Option[Boolean]] = column[Option[Boolean]]("is_disabled", O.Default(None))
    /** Database column created_date SqlType(DATETIME), Default(None) */
    val createdDate: Rep[Option[Date]] = column[Option[Date]]("created_date", O.Default(None))
    /** Database column updated_date SqlType(TIMESTAMP) */
    val updatedDate: Rep[Date] = column[Date]("updated_date")
  }
  /** Collection-like TableQuery object for table Contract */
  lazy val Contract = new TableQuery(tag => new Contract(tag))

  
  case class ContractBillRow(id: Long, customerId: Long, status: Option[String] = None, comment: Option[String] = None, contractDate: Option[Date] = None, cancelDate: Option[Date] = None, isDisabled: Option[Boolean] = None, createdDate: Option[Date] = None, updatedDate: Date, bill: BillRow)

  case class ContractBillSearchRow(customerId: Option[Long] = None, customerName: Option[String] = None,  status: Option[String] = None, contractDateFrom: Option[Date] = None, contractDateTo: Option[Date] = None, cancelDateFrom: Option[Date] = None, cancelDateTo: Option[Date] = None, billName: Option[String] = None, billEmail: Option[String] = None, billTel: Option[String] = None, billAddress: Option[String] = None)

    
  /** Entity class storing rows of table Customer
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param tel Database column tel SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param comment Database column comment SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param actionDate Database column action_date SqlType(DATETIME), Default(None)
   *  @param notificationPeriod Database column notification_period SqlType(INT), Default(None)
   *  @param notificationDate Database column notification_date SqlType(DATETIME), Default(None)
   *  @param isDisabled Database column is_disabled SqlType(TINYINT), Default(None)
   *  @param createdDate Database column created_date SqlType(DATETIME), Default(None)
   *  @param updatedDate Database column updated_date SqlType(TIMESTAMP) */
  case class CustomerRow(id: Long, name: Option[String] = None, email: Option[String] = None, tel: Option[String] = None, address: Option[String] = None, comment: Option[String] = None, actionDate: Option[Date] = None, notificationPeriod: Option[Int] = None, notificationDate: Option[Date] = None, isDisabled: Option[Boolean] = None, createdDate: Option[Date] = None, updatedDate: Date)
  /** GetResult implicit for fetching CustomerRow objects using plain SQL queries */
  implicit def GetResultCustomerRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Date]], e3: GR[Option[Int]], e4: GR[Option[Boolean]], e5: GR[Date]): GR[CustomerRow] = GR{
    prs => import prs._
    CustomerRow.tupled((<<[Long], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Date], <<?[Int], <<?[Date], <<?[Boolean], <<?[Date], <<[Date]))
  }
  /** Table description of table customer. Objects of this class serve as prototypes for rows in queries. */
  class Customer(_tableTag: Tag) extends Table[CustomerRow](_tableTag, "customer") {
    def * = (id, name, email, tel, address, comment, actionDate, notificationPeriod, notificationDate, isDisabled, createdDate, updatedDate) <> (CustomerRow.tupled, CustomerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, email, tel, address, comment, actionDate, notificationPeriod, notificationDate, isDisabled, createdDate, Rep.Some(updatedDate)).shaped.<>({r=>import r._; _1.map(_=> CustomerRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column tel SqlType(VARCHAR), Length(255,true), Default(None) */
    val tel: Rep[Option[String]] = column[Option[String]]("tel", O.Length(255,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(255,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(255,varying=true), O.Default(None))
    /** Database column comment SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val comment: Rep[Option[String]] = column[Option[String]]("comment", O.Length(16777215,varying=true), O.Default(None))
    /** Database column action_date SqlType(DATETIME), Default(None) */
    val actionDate: Rep[Option[Date]] = column[Option[Date]]("action_date", O.Default(None))
    /** Database column notification_period SqlType(INT), Default(None) */
    val notificationPeriod: Rep[Option[Int]] = column[Option[Int]]("notification_period", O.Default(None))
    /** Database column notification_date SqlType(DATETIME), Default(None) */
    val notificationDate: Rep[Option[Date]] = column[Option[Date]]("notification_date", O.Default(None))
    /** Database column is_disabled SqlType(TINYINT), Default(None) */
    val isDisabled: Rep[Option[Boolean]] = column[Option[Boolean]]("is_disabled", O.Default(None))
    /** Database column created_date SqlType(DATETIME), Default(None) */
    val createdDate: Rep[Option[Date]] = column[Option[Date]]("created_date", O.Default(None))
    /** Database column updated_date SqlType(TIMESTAMP) */
    val updatedDate: Rep[Date] = column[Date]("updated_date")
  }
  /** Collection-like TableQuery object for table Customer */
  lazy val Customer = new TableQuery(tag => new Customer(tag))

  /** Entity class storing rows of table OauthClient
   *  @param oauthClientId Database column oauth_client_id SqlType(BINARY), PrimaryKey
   *  @param oauthUserId Database column oauth_user_id SqlType(BINARY)
   *  @param clientSecret Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param redirectUri Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param grantType Database column grant_type SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(INT)
   *  @param createdDate Database column created_date SqlType(DATETIME) */
  case class OauthClientRow(oauthClientId: UUID, oauthUserId: UUID, clientSecret: Option[String] = None, redirectUri: Option[String] = None, grantType: Option[String] = None, expiresIn: Int, createdDate: Date)
  /** GetResult implicit for fetching OauthClientRow objects using plain SQL queries */
  implicit def GetResultOauthClientRow(implicit e0: GR[UUID], e1: GR[Option[String]], e2: GR[Int], e3: GR[Date]): GR[OauthClientRow] = GR{
    prs => import prs._
    OauthClientRow.tupled((<<[UUID], <<[UUID], <<?[String], <<?[String], <<?[String], <<[Int], <<[Date]))
  }
  /** Table description of table oauth_client. Objects of this class serve as prototypes for rows in queries. */
  class OauthClient(_tableTag: Tag) extends Table[OauthClientRow](_tableTag, "oauth_client") {
    def * = (oauthClientId, oauthUserId, clientSecret, redirectUri, grantType, expiresIn, createdDate) <> (OauthClientRow.tupled, OauthClientRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(oauthClientId), Rep.Some(oauthUserId), clientSecret, redirectUri, grantType, Rep.Some(expiresIn), Rep.Some(createdDate)).shaped.<>({r=>import r._; _1.map(_=> OauthClientRow.tupled((_1.get, _2.get, _3, _4, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column oauth_client_id SqlType(BINARY), PrimaryKey */
    val oauthClientId: Rep[UUID] = column[UUID]("oauth_client_id", O.PrimaryKey)
    /** Database column oauth_user_id SqlType(BINARY) */
    val oauthUserId: Rep[UUID] = column[UUID]("oauth_user_id")
    /** Database column client_secret SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientSecret: Rep[Option[String]] = column[Option[String]]("client_secret", O.Length(255,varying=true), O.Default(None))
    /** Database column redirect_uri SqlType(VARCHAR), Length(255,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("redirect_uri", O.Length(255,varying=true), O.Default(None))
    /** Database column grant_type SqlType(VARCHAR), Length(255,true), Default(None) */
    val grantType: Rep[Option[String]] = column[Option[String]]("grant_type", O.Length(255,varying=true), O.Default(None))
    /** Database column expires_in SqlType(INT) */
    val expiresIn: Rep[Int] = column[Int]("expires_in")
    /** Database column created_date SqlType(DATETIME) */
    val createdDate: Rep[Date] = column[Date]("created_date")
  }
  /** Collection-like TableQuery object for table OauthClient */
  lazy val OauthClient = new TableQuery(tag => new OauthClient(tag))

  
  case class OauthClientSearchRow(oauthUserId: Option[String] = None, oauthUserName: Option[String] = None)

  /** Entity class storing rows of table OauthUser
   *  @param guid Database column guid SqlType(BINARY), PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param createdDate Database column created_date SqlType(DATETIME) */
  case class OauthUserRow(guid: UUID, name: String, createdDate: Date)
  /** GetResult implicit for fetching OauthUserRow objects using plain SQL queries */
  implicit def GetResultOauthUserRow(implicit e0: GR[UUID], e1: GR[String], e2: GR[Date]): GR[OauthUserRow] = GR{
    prs => import prs._
    OauthUserRow.tupled((<<[UUID], <<[String], <<[Date]))
  }
  /** Table description of table oauth_user. Objects of this class serve as prototypes for rows in queries. */
  class OauthUser(_tableTag: Tag) extends Table[OauthUserRow](_tableTag, "oauth_user") {
    def * = (guid, name, createdDate) <> (OauthUserRow.tupled, OauthUserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(guid), Rep.Some(name), Rep.Some(createdDate)).shaped.<>({r=>import r._; _1.map(_=> OauthUserRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column guid SqlType(BINARY), PrimaryKey */
    val guid: Rep[UUID] = column[UUID]("guid", O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column created_date SqlType(DATETIME) */
    val createdDate: Rep[Date] = column[Date]("created_date")
  }
  /** Collection-like TableQuery object for table OauthUser */
  lazy val OauthUser = new TableQuery(tag => new OauthUser(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param hash Database column hash SqlType(VARCHAR), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(TIMESTAMP)
   *  @param applyScript Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param revertScript Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    PlayEvolutionsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends Table[PlayEvolutionsRow](_tableTag, "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (PlayEvolutionsRow.tupled, PlayEvolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem).shaped.<>({r=>import r._; _1.map(_=> PlayEvolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(VARCHAR), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(TIMESTAMP) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Length(16777215,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))
}
