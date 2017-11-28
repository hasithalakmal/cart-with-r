library(rpart)
library(rpart.plot)


train_data <- read.table("/home/hasithagamage/cart_data.csv", header=TRUE, sep=",")
cart_tree <- rpart(Profit ~ Duration  + Genres + Director.Name + Actor.Name + Country + Language + BudgetID, method="class", data=train_data, control=rpart.control(minsplit=2, minbucket=1, cp=0.0001))
predict_data <- read.table("/home/hasithagamage/predict_data.csv", header=TRUE, sep=",")
prediction_of_predict_data <- predict(cart_tree, predict_data, type="class")
write.csv(prediction_of_predict_data, file = "/home/hasithagamage/predict_result.csv")

