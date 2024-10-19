package com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager.info

enum class DriverManagerInfoEnum(
    val value:String,
) {
    JDBC(value = "jdbc"),
    SQL_ENGINE(value = "mysql"),
    IPV4(value = "35.194.200.2"),
    PORT(value = "3306"),
    DATABASE_NAME(value = "healthy"),
    URL(value = "${JDBC.value}"+":" +
            "${SQL_ENGINE.value}" +"://" +
            "${IPV4.value}" + ":" +
            "${PORT.value}" + "/" +
            "${DATABASE_NAME.value}"
    ),
    USERNAME(value = "dev"),
    PASSWORD(value = "0000"),
}