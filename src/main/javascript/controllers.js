var controllers = angular.module("controllers", []);

controllers.controller("HomeController", ['$scope', '$http', 'TaskPaper', function ($scope, $http, TaskPaper) {
    $scope.debug = false;
    $scope.data = TaskPaper.query();
    $scope.editing = false;

    if (typeof String.prototype.endsWith !== 'function') {
        String.prototype.endsWith = function (suffix) {
            return this.indexOf(suffix, this.length - suffix.length) !== -1;
        };
    }

    function padStr(i) {
        return (i < 10) ? "0" + i : "" + i;
    }

    function printDate() {
        var tmpDate = new Date();
        return padStr(tmpDate.getFullYear()) + "-" +
               padStr(1 + tmpDate.getMonth()) + "-" +
               padStr(tmpDate.getDate());
    }


    $scope.adjustDone = function (task) {
        task.done = !task.done;
        if (task.done) {
            task.task += " @done(" + printDate() + ")";
        } else {
            task.task = task.task.replace(/@done(\(.*\))?/g, ''); //remove all @done tags
        }
    };

    $scope.addTask = function () {
        if ($scope.todo.topic != null) {
            $scope.todo.topic.tasks.push({task: $scope.todo.task, done: $scope.todo.task.contains("@done")});

        } else {
            if ($scope.todo.task.endsWith(":")) {
                $scope.data.topics.push({title: $scope.todo.task, tasks: []})
            } else {
                $scope.data.tasks.push({task: $scope.todo.task, done: false});
            }
        }
        $scope.todo.task = "";
    };

    $scope.toggleDebug = function () {
        $scope.debug = !$scope.debug;
    };
}

])
;