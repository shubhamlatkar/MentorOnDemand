# Course-Service

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

### /course/

#### GET

##### Summary

filterCourse

##### Parameters

| Name     | Located in | Description | Required | Schema |
| -------- | ---------- | ----------- | -------- | ------ |
| filterBy | query      | filterBy    | No       | string |
| limit    | query      | limit       | No       | string |
| page     | query      | page        | No       | string |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

#### POST

##### Summary

postCourse

##### Parameters

| Name   | Located in | Description | Required | Schema            |
| ------ | ---------- | ----------- | -------- | ----------------- |
| course | body       | course      | Yes      | [Course](#course) |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 201  | Created      |        |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

#### PATCH

##### Summary

patchCourse

##### Parameters

| Name   | Located in | Description | Required | Schema            |
| ------ | ---------- | ----------- | -------- | ----------------- |
| course | body       | course      | Yes      | [Course](#course) |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 204  | No Content   |        |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |

### /course/topic/{title}

#### GET

##### Summary

getTopics

##### Parameters

| Name  | Located in | Description | Required | Schema |
| ----- | ---------- | ----------- | -------- | ------ |
| title | path       | title       | Yes      | string |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

### /course/{title}

#### GET

##### Summary

getCourse

##### Parameters

| Name  | Located in | Description | Required | Schema |
| ----- | ---------- | ----------- | -------- | ------ |
| title | path       | title       | Yes      | string |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |
| 404  | Not Found    |        |

#### DELETE

##### Summary

deleteCourse

##### Parameters

| Name  | Located in | Description | Required | Schema |
| ----- | ---------- | ----------- | -------- | ------ |
| title | path       | title       | Yes      | string |

##### Responses

| Code | Description  | Schema |
| ---- | ------------ | ------ |
| 200  | OK           | object |
| 204  | No Content   |        |
| 401  | Unauthorized |        |
| 403  | Forbidden    |        |


### Models

#### Course

| Name        | Type                | Description | Required |
| ----------- | ------------------- | ----------- | -------- |
| description | string              |             | No       |
| duration    | string              |             | No       |
| fee         | string              |             | No       |
| id          | string              |             | No       |
| lectures    | string              |             | No       |
| levels      | string              |             | No       |
| mentorId    | string              |             | No       |
| reviews     | string              |             | No       |
| title       | string              |             | No       |
| topics      | [ [Topic](#topic) ] |             | No       |

#### Link

| Name      | Type    | Description | Required |
| --------- | ------- | ----------- | -------- |
| href      | string  |             | No       |
| templated | boolean |             | No       |

#### Map«string,Link»

| Name             | Type   | Description | Required |
| ---------------- | ------ | ----------- | -------- |
| Map«string,Link» | object |             |          |

#### Topic

| Name      | Type    | Description | Required |
| --------- | ------- | ----------- | -------- |
| completed | boolean |             | No       |
| name      | string  |             | No       |

#### View

| Name        | Type   | Description | Required |
| ----------- | ------ | ----------- | -------- |
| contentType | string |             | No       |
