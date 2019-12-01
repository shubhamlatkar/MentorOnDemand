$(document).ready(function() {

    $('#users-edit-div').hide();       
    $('#users-notification-div').hide();
    $('#users-completed-tranings-div').hide();
    $('#users-payment-div').hide();
    $('#users-current-trainings-div').hide();

    $('#users-edit-button').on('click', function() {
        $('#users-edit-div').show();       
        $('#users-current-trainings-div').hide();
        $('#users-notification-div').hide();
        $('#users-completed-tranings-div').hide();
        $('#users-payment-div').hide();
    });

    $('#users-payment-button').on('click',function() {
        $('#users-payment-div').show();
        $('#users-notification-div').hide();
        $('#users-completed-tranings-div').hide();
        $('#users-edit-div').hide();
        $('#users-current-trainings-div').hide();
    });

    $('#users-currentTraining-button').on('click', function() {
        $('#users-current-trainings-div').show();
        $('#users-notification-div').hide();
        $('#users-payment-div').hide();
        $('#users-completed-tranings-div').hide();
        $('#users-edit-div').hide();
    });

    $('#users-completedTraining-button').on('click', function() {
        $('#users-completed-tranings-div').show();
        $('#users-notification-div').hide();
        $('#users-payment-div').hide();
        $('#users-edit-div').hide();
        $('#users-current-trainings-div').hide();
    });

    $('#users-notification-button').on('click', function() {
        $('#users-notification-div').show();
        $('#users-completed-tranings-div').hide();
        $('#users-payment-div').hide();
        $('#users-edit-div').hide();
        $('#users-current-trainings-div').hide();
    });

    $('#add-more-button').on('click', function() {
        var div = `
                <div class="form-row">
                    <div class="form-group col-md-7">
                    <label for="inputCity">Cources</label>
                        <select id="inputState" class="form-control">
                            <option selected>Choose Cource...</option>
                            <option value="Java">Java</option>
                            <option value="Python">Python</option>
                            <option value="Node">Node</option>
                            <option value="Spring">Spring</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputState">Fee</label>
                        <input type="number" class="form-control" placeholder="$">
                    </div>
                    <div class="form-group col-md-1">
                        <label for="add-more-button">Add</label>
                        <button type="button" class="form-control" id="add-more-button"><span class="fa fa-plus"></span></button>
                    </div>
                </div>
        `;
        $('#cource-input-holder').append(div);
    });

});