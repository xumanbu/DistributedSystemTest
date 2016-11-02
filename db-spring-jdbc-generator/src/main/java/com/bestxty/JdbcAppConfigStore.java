package com.bestxty;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAppConfigStore implements WechatAppConfigStore {

    private static final String APP_CONFIG_SELECT_BY_APP_ID_STATEMENT = "SELECT * FROM wechat_app_config WHERE app_id = ?";
    private static final String APP_CONFIG_SELECT_BY_ID_STATEMENT = "SELECT * FROM wechat_app_config WHERE id = ?";

    private final JdbcTemplate mJdbcTemplate;

    public JdbcAppConfigStore(DataSource dataSource) {
        mJdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public WechatAppConfig getWechatAppConfigByAppId(String appId) {
        return mJdbcTemplate.queryForObject(APP_CONFIG_SELECT_BY_APP_ID_STATEMENT,
                new AppConfigRowMapper(), appId);
    }

    @Override
    public WechatAppConfig getWechatAppConfig(String id) {
        return mJdbcTemplate.queryForObject(APP_CONFIG_SELECT_BY_ID_STATEMENT,
                new AppConfigRowMapper(), id);
    }


    private final class AppConfigRowMapper implements RowMapper<WechatAppConfig> {

        @Override
        public WechatAppConfig mapRow(ResultSet rs, int rowNum) throws SQLException {

            WechatAppConfig appConfig = new WechatAppConfig();

            appConfig.setId(rs.getString("id"));
            appConfig.setAppId(rs.getString("app_id"));
            appConfig.setSecret(rs.getString("secret"));
            appConfig.setLocked(rs.getBoolean("locked"));
            appConfig.setEnabled(rs.getBoolean("enabled"));
            appConfig.setCreateTime(rs.getDate("create_time"));

            return appConfig;
        }
    }
}
