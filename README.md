# CallDetailsMS
my test devops project

#deploy mysql in minikube
kubectl apply -f mysql-deployment.yaml
kubectl exec -it <pod_name> bash
mysql -h mysql -u root -p 
