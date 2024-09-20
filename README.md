# Devops
Devops repo 

Last week Terraform part was pending.
Monday:
1. Completed the Terraform coding part.
2. Tried to test the code in azure devops pipeline.
3. But due to some service connection misconfiguration I couldn't test the full flow.
4. From jira to Azure pipeline flow is working. But the pipeline execution still failing.

Tuesday:
1. Pipeline issue resolved, But adding fresh secretkeys to Service-connection. Post that Terraform Plan was successful in azure pipeline.
2. But the Terraform apply was failing with permission issue for AD.
3. Later fixed it by changing the service connection to Application_Admin. 
4. One more issue noticed that the User select and its associated email is not similar to Azure AD user.
5. So whatever jira value that we select in Jira Form, Won't map with Azure AD data.

Wednesday:
1. Tried to perform a ceanup of infra which was created with state file in wrong RG location.
2. Fixed the user name issue by hardcoding the usernames.
3. Post meeting, Jira Form Cleanup is done.
4. Terraform code cleanup also done.
5. Service connection details are updated in the pipeline.
6. Old Infra was cleaned up which created the state file in wrong storage account.
7. Confirmed new Updated Jira Form reaches the App Function and Pipeline Job got triggered.
8. Terraform apply was successful.

Thursday:
1. Started analysiing the feedback loop of azure pipeline to jira field.
2. Tried multiple option, Throwing different different error.
3. In the mean time, AZure Devops PAT got expired. After a long analysis finally Identified that and fixed it.
4. Later identified a way to catch the pipeline staus and post the status to jira. But not tested.

Friday:
1. I tried to post pipeline status based on deops events in pipeline staged. Tried with RESTAPI, Facing some issue.
2. Tried to post comment from local and finalized the command.
3. Integrated it with azure pipeline as script and triggered the build.
4. Verified the comments are added to the jira.
5. Looking at other possible places like azure function to add notification.
6. CMDB integration is also in progress.

