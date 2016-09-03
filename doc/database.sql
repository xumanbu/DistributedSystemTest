CREATE DATABASE fogcloud;

USE fogcloud;

-- used in tests that use HSQL
CREATE TABLE oauth_client_details (
  client_id               VARCHAR(256),
  resource_ids            VARCHAR(256),
  client_secret           VARCHAR(256),
  scope                   VARCHAR(256),
  authorized_grant_types  VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities             VARCHAR(256),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(256)
);

CREATE TABLE oauth_client_token (
  token_id          VARCHAR(256),
  token             BLOB,
  authentication_id VARCHAR(256),
  user_name         VARCHAR(256),
  client_id         VARCHAR(256)
);

CREATE TABLE oauth_access_token (
  token_id          VARCHAR(256),
  token             BLOB,
  authentication_id VARCHAR(256),
  user_name         VARCHAR(256),
  client_id         VARCHAR(256),
  authentication    BLOB,
  refresh_token     VARCHAR(256)
);

CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(256),
  token          BLOB,
  authentication BLOB
);

CREATE TABLE oauth_code (
  code           VARCHAR(256),
  authentication BLOB
);

CREATE TABLE oauth_approvals (
  userId         VARCHAR(256),
  clientId       VARCHAR(256),
  scope          VARCHAR(256),
  status         VARCHAR(10),
  expiresAt      TIMESTAMP,
  lastModifiedAt TIMESTAMP DEFAULT now()
);

-- customized oauth_client_details table
CREATE TABLE ClientDetails (
  appId                  VARCHAR(256),
  resourceIds            VARCHAR(256),
  appSecret              VARCHAR(256),
  scope                  VARCHAR(256),
  grantTypes             VARCHAR(256),
  redirectUrl            VARCHAR(256),
  authorities            VARCHAR(256),
  access_token_validity  INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation  VARCHAR(4096),
  autoApproveScopes      VARCHAR(256)
);


insert into oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri,authorities, access_token_validity,
 refresh_token_validity, additional_information)
values
  ('unity-client','unity-resource', 'unity', 'read,write','authorization_code,refresh_token,implicit',
   null,'ROLE_CLIENT',null,
   null,null),
  ('mobile-client','mobile-resource', 'mobile', 'read,write','password,refresh_token',
   null,'ROLE_CLIENT',null,
   null,null);