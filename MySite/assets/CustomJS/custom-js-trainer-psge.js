$(document).ready(function() {

    $('#trainers-edit-div').hide();       
    $('#trainers-notification-div').hide();
    $('#trainers-completed-tranings-div').hide();
    $('#trainers-payment-div').hide();
    $('#trainers-current-trainings-div').hide();

    $('#trainers-edit-button').on('click', function() {
        $('#trainers-edit-div').show();       
        $('#trainers-current-trainings-div').hide();
        $('#trainers-notification-div').hide();
        $('#trainers-completed-tranings-div').hide();
        $('#trainers-payment-div').hide();
    });

    $('#trainers-payment-button').on('click',function() {
        $('#trainers-payment-div').show();
        $('#trainers-notification-div').hide();
        $('#trainers-completed-tranings-div').hide();
        $('#trainers-edit-div').hide();
        $('#trainers-current-trainings-div').hide();
    });

    $('#trainers-currentTraining-button').on('click', function() {
        $('#trainers-current-trainings-div').show();
        $('#trainers-notification-div').hide();
        $('#trainers-payment-div').hide();
        $('#trainers-completed-tranings-div').hide();
        $('#trainers-edit-div').hide();
    });

    $('#trainers-completedTraining-button').on('click', function() {
        $('#trainers-completed-tranings-div').show();
        $('#trainers-notification-div').hide();
        $('#trainers-payment-div').hide();
        $('#trainers-edit-div').hide();
        $('#trainers-current-trainings-div').hide();
    });

    $('#trainers-notification-button').on('click', function() {
        $('#trainers-notification-div').show();
        $('#trainers-completed-tranings-div').hide();
        $('#trainers-payment-div').hide();
        $('#trainers-edit-div').hide();
        $('#trainers-current-trainings-div').hide();
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