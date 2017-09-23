library(rpart)
library(rpart.plot)

imdb6 <- read.table("/home/hasithagamage/cart_data.csv", header=TRUE, sep=",")
str(imdb6)
table(imdb6$isProfitable)
g <- runif(nrow(imdb6))
imdb <- imdb6[order(g),]
head(imdb)

fit <- rpart(Profit ~ Duration  + Genres + Director.Name + Actor.Name + Country + Language + BudgetID, method="class", data=imdb6, control=rpart.control(minsplit=2, minbucket=1, cp=0.0001))
png(file = "/home/hasithagamage/decision_tree.png")
rpart.plot(fit)
dev.off()

testData <- read.table("/home/hasithagamage/predict_data.csv", header=TRUE, sep=",")

p3 <- predict(fit, imdb[1:1,], type="class")

write.csv(p3, file = "/home/hasithagamage/predict_result.csv")