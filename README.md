# Devops
Devops repo 

Last week Terraform part was pending.
Monday:
1. 1. Enabled the jira comment addition from azure function.
2. Added the CMDB field into the jira form and cleaned up the remaining fields from jira form.
3. Constructed the automation rule to pass the CMDB data field to Azure function.
4. Verified that the azure function could able to hit CMDB and retrive dtat from it.
5. Still we need to parse the CMDB API respose to filterout the required filed and validation checks need to be added. - Inprogress

Tuesday:
1. CMDB Json parsing is done and I could validate the required fields.
2. Subscription validation is also done and feedback is posted to AZure.
3. rg and SPN validation code are implemented, Need to test the code changes.
   

Wednesday:
1. Need clarification on Subscription  Env and Resource Group Env
2. What ever environments given in JSM not mapped to subscription ENV
3. Most of the time spend on this service principal validation and implementation.(Still pending)
   

Thursday:
1. 1. API validation for subscription with rg and SPNs check before ado validation - Done 
2. ⁠CMDB Params cleanup in az function - Done 
3. ⁠Azure automation flow condition trigger for re-post the issue (validation failure scenarios ) - Done 
4. ⁠ADO pipeline tf approval and select subscription option after tf plan - Done

Friday:
1. testing
