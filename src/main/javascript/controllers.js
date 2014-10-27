var controllers = angular.module("controllers", []);

controllers.controller("HomeController", ['$scope', '$http', 'TaskPaper', function ($scope, $http, TaskPaper) {
    $scope.debug = true;
    $scope.data = TaskPaper.query();
    $scope.editing = false;


    function padStr(i) {
        return (i < 10) ? "0" + i : "" + i;
    }

    function printDate() {
        var tmpDate = new Date();
        return padStr(tmpDate.getFullYear()) + "-" +
               padStr(1 + tmpDate.getMonth()) + "-" +
               padStr(tmpDate.getDate());
    }


    $scope.adjustReason = function (task) {
        task.done = !task.done;
        if (task.done) {
            task.reason = "@done(" + printDate() + ")";
        } else {
            task.reason = "";
        }
    };

    $scope.addTask = function () {
        if ($scope.todo.topic != null) {
            $scope.todo.topic.tasks.push({task: $scope.todo.task, done: false, reason: null});
        } else {
            $scope.data.tasks.push({task: $scope.todo.task, done: false, reason: null});
        }
        $scope.todo = null;
    };

    $scope.toggleDebug = function () {
        $scope.debug = !$scope.debug;
    };
}

])
;