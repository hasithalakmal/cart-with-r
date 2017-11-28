library(rpart)
library(rpart.plot)


print(">>>>>>>>>>>>>>>>>>>>>> READ TRAINING DATA EXCEL FILE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
train_data <- read.table("/home/hasithagamage/cart_data.csv", header=TRUE, sep=",")

print(">>>>>>>>>>>>>>>>>>>>>> PRINT TRAINING DATA SET>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
print(train_data)

print(">>>>>>>>>>>>>>>>>>>>>> STR TRAINGN DATA - NI >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
str(train_data)

print(">>>>>>>>>>>>>>>>>>>>>> PRINT TRAINING DATA >>>>>>>>>>>>>>>>>>>>>>>>>>>>")
print(train_data)

print(">>>>>>>>>>>>>>>>>>>>>> CREATE TABLE FROM TRAINING DATA >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
table(train_data$isProfitable)

print(">>>>>>>>>>>>>>>>>>>>>> GET NUMBER OF ROWS FROM TRAINING DATA  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
g <- runif(nrow(train_data))

print(">>>>>>>>>>>>>>>>>>>>>> PRINT NUMBER OF ROWS OF TRAINING DATA >>>>>>>>>>>>>>>>>>>>>>>>>>>>")
print(g)

print(">>>>>>>>>>>>>>>>>>>>>> CALCULATE XXXX OF TRAINING DATA >>>>>>>>>>>>>>>>>>>>>>>>>>>>")
xxx <- train_data[order(g),]

print(">>>>>>>>>>>>>>>>>>>>>> PRINT XXXX >>>>>>>>>>>>>>>>>>>>>>>>>>>>")
print(xxx)

print(">>>>>>>>>>>>>>>>>>>>>> CREATE TREE FROM TRAINING DATA >>>>>>>>>>>>>>>>>>>>>")
cart_tree <- rpart(Profit ~ Duration  + Genres + Director.Name + Actor.Name + Country + Language + BudgetID, method="class", data=train_data, control=rpart.control(minsplit=2, minbucket=1, cp=0.0001))

print(">>>>>>>>>>>>>>>>>>>>>> PRINT CART TREE >>>>>>>>>>>>>>>>>>>>>>>>>>>>")
print(cart_tree)

print(">>>>>>>>>>>>>>>>>>>>>> CREATE PNG FILE >>>>>>>>>>>>>>>>>>>>>")
png(file = "/home/hasithagamage/decision_tree.png")

print(">>>>>>>>>>>>>>>>>>>>>> PLOT CART TREE >>>>>>>>>>>>>>>>>>>>>")
rpart.plot(cart_tree)

print(">>>>>>>>>>>>>>>>>>>>>> APPEND PLOTTED TREE IN TO PNG >>>>>>>>>>>>>>>>>>>>>")
dev.off()