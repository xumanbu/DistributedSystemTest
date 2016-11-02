package ${package};

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc${tableName}Store implements ${tableName}Store {

private static final String APP_CONFIG_SELECT_BY_APP_ID_STATEMENT = "SELECT * FROM wechat_app_config WHERE app_id = ?";
private static final String APP_CONFIG_SELECT_BY_ID_STATEMENT = "SELECT * FROM wechat_app_config WHERE id = ?";

private final JdbcTemplate mJdbcTemplate;

public Jdbc${tableName}Store(DataSource dataSource) {
mJdbcTemplate = new JdbcTemplate(dataSource);
}

@Override
public ${tableName} get${tableName}ByAppId(String appId) {
return mJdbcTemplate.queryForObject(APP_CONFIG_SELECT_BY_APP_ID_STATEMENT,
new ${tableName}RowMapper(), appId);
}

@Override
public ${tableName} get${tableName}(String id) {
return mJdbcTemplate.queryForObject(APP_CONFIG_SELECT_BY_ID_STATEMENT,
new ${tableName}RowMapper(), id);
}


private final class ${tableName}RowMapper implements RowMapper<${tableName}> {

@Override
public ${tableName} mapRow(ResultSet rs, int rowNum) throws SQLException {

${tableName} appConfig = new ${tableName}();

<#list columnList as column>
<#if
appConfig.set${column.displayColumnName}(rs.getString("${column.columnName}"));
</#list>
return appConfig;
}
}
}
