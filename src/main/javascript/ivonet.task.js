/**
 * Created by ivonet on 2014-31-10.
 */
"use strict";

app.directive("task", function () {
    return {
        restrict: 'E',
        replace: true,
        scope: {value: '='},
        template: '<ul ng-repeat="task in value"> \
                    <li class="list-unstyled" data-ng-class="{\'task-done\': task.done}"> \
                        <label> \
                            <input type="checkbox" ng-model="task.done" ng-click="adjustDone(task)"/> \
                        </label> \
                        <edit-in-place value="task.task" ></edit-in-place> \
                    </li> \
                </ul>',
        link: function (scope, elem, attrs) {
            elem.style.textde
        }
    };
});