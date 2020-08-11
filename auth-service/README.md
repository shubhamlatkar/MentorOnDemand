# Auth Service
Api Documentation

## Version: 1.0

### Terms of service
urn:tos

**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### /actuator

#### GET
##### Summary

links

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /actuator/health

#### GET
##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| body | body | body | No | object |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /actuator/health/**

#### GET
##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| body | body | body | No | object |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /actuator/info

#### GET
##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| body | body | body | No | object |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/login

#### POST
##### Summary

getJwtToken

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| request | body | request | Yes | [LoginRequest](#loginrequest) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [JwtResponse](#jwtresponse) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/logmeout

#### GET
##### Summary

logout

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/logoutall

#### GET
##### Summary

logoutAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/secured

#### GET
##### Summary

getTest

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/signup

#### POST
##### Summary

signupUser

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| signupRequest | body | signupRequest | Yes | [SignupRequest](#signuprequest) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /auth/tryAutoLogin

#### GET
##### Summary

tryAutoLogin

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### Models

#### JwtResponse

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| accessToken | string |  | No |
| id | string |  | No |
| tokenType | string |  | No |
| username | string |  | No |

#### Link

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| href | string |  | No |
| templated | boolean |  | No |

#### LoginRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| password | string |  | No |
| username | string |  | No |

#### Map«string,Link»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| Map«string,Link» | object |  |  |


#### SignupRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| email | string |  | No |
| password | string |  | No |
| role | [ string ] |  | No |
| roles | [ string ] |  | No |
| username | string |  | No |

#### View

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| contentType | string |  | No |
