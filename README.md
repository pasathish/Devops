# Devops
Devops repo 

Last week Terraform part was pending.
Monday:


Tuesday:
1. View permission to see the KV secret. ( For Demo)
2. Resource cleanup and keeping the clean for Demo
3. Removed the policies that are associated with Management Group.
4. Started working on policy as code.
   

Wednesday:
1. Configured the azure devops pipeline for Policy as Code.
2. Designed the terraform workflow as a gitOps way for policy creation and policy attacment.
3. Wrote a simple policy to attach to the a resource scope and tested the pipeline.
4. JSM Demo session
5. New policies are created via json definitions
   

Thursday:
1. Explored the other possibilites of policy attachment scope.
2. Enhanced the terraform moduled to support below set of policy attachment scopes.
   1. Resource Scope
   2. Resource_Group Scope 
   3. Management Scope
   4. Subscription  Scope
3. Above scopes are parameterised and cleanly handeled via tfvars.
4. Terraform plan for new policy creation and attachment was successfull.
5. Facing challenges while doing terraform apply. Service Connectio is not having permission to create policies.
6. Validating pipeline for built in policies and Custom policies.


Friday:
1. Addressing JSM feedback.

