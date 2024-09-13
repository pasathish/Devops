# Devops
Devops repo 


 Monday:
 On Demand Subscription option is implemented(Pull model) with 5min cache. Initially it was manual trigger from app function. 

Tuesday:
1. Deployed the Azure function template to expose the endpoint for trigger.
2. Jira webhook created to trigger app function . Initially it was not triggering later I made tweak to make the trigger. 
3. Verified that the function is triggered via app-function metrics.
4. Facing issues with logs to know the Json format of Data retrived from trigger.
5. Fixed the subscription dynamic filed. Due to token expiry data didn't loaded properly.  Changed the Function authentication form FUNCTION to Anonymous.

Wednesday:
1. Jira form datas cannot be pushed from jira to Azure function. Feature is not availabe so far. Only custome_fiels are supported right now.
https://jira.atlassian.com/browse/JSDCLOUD-10697 - Blocker. Atlassin is started thier work to support this on july 29th 2024. Not sure when this will be released.
2. Configured the logging setup for app-fuction. Which helps to identifying the json structure in appfunction.
3. Creates 4 to 5 service request and noticed the form field were not populated via jira webhook payload.
4. Since formdata is not available in jira webhook method, Configured the automation rule in Help desk project.
5. Tried with different mode of payload to get the formdata. This also didn't help.
6. Later identified an open issue were smart value is not available for form datas. We need to handel is separately. Currently this feature is under development. https://jira.atlassian.com/browse/JSDCLOUD-10697
7. Couple of work arround has identified and we could get the form data. But it need logical post processing.
  1. First one is RestAPI.
  2. Second one is automation rule with some magical index mapping.
8.  I got the JSON payload structure and will start the app function coding part.

Thursday:
1. Finally,Today I couldable to break the complex json of dynamic form in jira automation.  
2. Tested the json payload by triggering the new jira request. 
3. jira automation custom form payload was sucessfully parsed in azure-app function.
4. Again in azure function we need to do some numbering logic to pick correct option as configured in jira request. Which was done and tested.
5. Created a new azure repository for residency mvp. 
6. Copied the azure devops  pipeline of vmtest repo to new residency mvp repo.
7. From azure function, I managed to trigger the new azure devops pipeline with existing APIToken.
8. Custom payload for residency mvp pipeline was configured from azure function.
9. Azure pipeline paramete list are also updated based on custom payload that we sent via app function.
10. Terraform part is pending.
