import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "When a POST request is made, the new userid should be returned"
	request {
		method 'POST'
		urlPath '/new'
		body([
			//"userid":44,
			"firstName": "nithii",
			"lastName": "nithi",
			"email": "nith@gmail.com"
			])
		//stubMatchers {
			//jsonPath('$.', byRegex('[2-9][0-9]'))
			//}
		headers {
			header('Content-Type', 'application/json;charset=UTF-8')
			}
		}	
	response{
		status 201
			body([ 
  		      //		  "userid": 66
				])
		headers {
			header('Content-Type', 'application/json;charset=UTF-8')
				}
		}
}	 