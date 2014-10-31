/**
 * Created by ivonet on 2014-31-10.
 */

app.directive('topic', function () {
    return {
        restrict: 'E',
        scope: {value: '='},
        template: '<ul class="list-unstyled"  ng-repeat="topic in value"> \
                    <li class="list-unstyled"> \
                        <h2><edit-in-place value="topic.title"></edit-in-place></h2> \
                        <task value="topic.tasks"></task> \
                    </li> \
                </ul>'
    }

});
