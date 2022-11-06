# SimpleEvent-DrivenMicroserviceArchtWithRabbitMQ

### We have three microservices ,and we use RabbitMQ as Message Broker between those services
#### 1.OrderService
#### 2.StockService
#### 3.EmailService


#### Basically, Order service sends events to Exchange and, Exchange route that messages to Queues via RoutingKeys  
#### And StockService and EmailServices consume these queues  (Order Queue and Email Queue)
#### We have 2 queue, StockServices subscribe the OrderQueue and EmailService subscribe the Email Queue

