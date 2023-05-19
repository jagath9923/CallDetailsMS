# CallDetailsMS
my test devops project

#deploy mysql in minikube
kubectl apply -f mysql-deployment.yaml
kubectl exec -it <pod_name> bash
mysql -h mysql -u root -p 

<service-name>.<namespace>.svc.cluster.local:<service-port>

minikube service --url calldetailsms-service

kubectl port-forward service/calldetailsms-service 8081:8080
