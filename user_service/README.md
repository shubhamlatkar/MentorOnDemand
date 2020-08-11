# User Service

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

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /actuator/health

#### GET

##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| body | body       | body        | No       | object |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /actuator/health/\*\*

#### GET

##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| body | body       | body        | No       | object |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /actuator/info

#### GET

##### Summary

handle

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| body | body       | body        | No       | object |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /user/

#### GET

##### Summary

getUser

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

#### POST

##### Summary

postUser

##### Parameters

| Name | Located in | Description | Required | Schema              |
| ---- | ---------- | ----------- | -------- | ------------------- |
| user | body       | user        | Yes      | [UserDto](#userdto) |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 201  | Created      |        |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

#### PUT

##### Summary

putUser

##### Parameters

| Name | Located in | Description | Required | Schema              |
| ---- | ---------- | ----------- | -------- | ------------------- |
| user | body       | user        | Yes      | [UserDto](#userdto) |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 201  | Created      |        |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /user/trainer/{name}

#### GET

##### Summary

getTrainerByName

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| name | path       | name        | Yes      | string |

#### UserDto

| Name        | Type   | Description | Required |
| ----------- | ------ | ----------- | -------- |
| company     | string |             | No       |
| description | string |             | No       |
| email       | string |             | No       |
| expertise   | string |             | No       |
| fullName    | string |             | No       |
| phone       | string |             | No       |
| position    | string |             | No       |
| username    | string |             | No       |
