$(document).ready(function() {
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

    $("#searchTrainer").on("keyup", function() {
        let value = $(this).val().toLowerCase();   
        $('.trainers-card').hide();
        $('.trainers-card').each(function() {
            let name =  $(this).find('h4').first().text().toLowerCase();
            if(name.indexOf(value) != -1) {
                $(this).show();
            }
        });
    });

    $('.serach-filter-dropdown a').on('click', function() {
        let val = $(this).text().toLowerCase().trim();
        $('.trainers-card').hide();
        $('.trainers-card').each(function() {
            let name =  $(this).find('.expert-area').text().toLowerCase();
            if(name.indexOf(val) != -1) {
                $(this).show();
            }        
        });    
    });

    var sideBarToggle = false;    

    $('#sideBarButton').click(function() {
        if(sideBarToggle) {
            $('#sideBarContent').hide();
            $('#sideBarContent').removeClass('col-sm-2');
            $('#dashboardContent').removeClass('col-sm-10');
            $('#dashboardContent').addClass('col-sm-12');
            sideBarToggle = !sideBarToggle;
        } else {
            $('#sideBarContent').show();
            $('#sideBarContent').addClass('col-sm-2');
            $('#dashboardContent').removeClass('col-sm-12');
            $('#dashboardContent').addClass('col-sm-10');
            sideBarToggle = !sideBarToggle;
        }

    }); 

    var names = [
        {
            'id':'1',
            'name':'shubham latkar',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':1,
            'expertArea':'java',
            
        },
        {    
            'id':'2',
            'name':'kunal',
            'occ': 'CEO at WalMart',
            'univ': 'MIT',
            'exp': '2yrs',
            'role':2,
            'expertArea':'cloud',
        }, 
        {
            'id':'3',
            'name':'prerna',
            'occ':'Founder at Cnt+C/cntl+V',
            'univ':'Bhopal Univ',
            'exp':'12yrs',
            'role':2,
            'expertArea':'python',
        },
        {
            'id':'4',
            'name':'saloni',
            'occ':'CEO at Cnt+C/cntl+V',
            'univ': 'Bhopal Univ',
            'exp':'10yrs',
            'role':2,
            'expertArea':'python',
        },
        {   
            'id':'5',
            'name':'raju',
            'occ': ' CEO at Pepsi Inc',
            'univ': 'California Institute of Tech.',
            'exp': '4yrs',
            'role':2,
            'expertArea':'python',
         }, 
         {  
            'id':'6',
            'name':'shivam',
            'occ': 'Founder of Mahakal Inc',
            'univ': 'Ujjain University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'cloud',
        },
        {
            'id':'7',
            'name':'shravan',
            'occ': 'Founder of DIY',
            'univ': 'Chicago Univesity',
            'exp': '5yrs',
            'role':2,
            'expertArea':'cloud',
        },     
        {   
            'id':'8',
            'name':'rohit',
            'occ': 'CEO of Amazon Inc',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'cloud', 
        },
        {   
            'id':'9',
            'name':'mihir',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'python', 
        },
        {   
            'id':'10',
            'name':'rushikesh',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'python',
        },
        {   
            'id':'11',
            'name':'sagar',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'python',
        },
        {   
            'id':'12',
            'name': 'rahul',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':2,
            'expertArea':'java',
        },
        {   
            'id':'13',
            'name':'neilTrainer',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'java',
        },
        {   
            'id':'14',
            'name': 'gauravTrainer',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'java',
        },
        {   
            'id':'15',
            'name': 'sankeshTrainer',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'python',
        },
        {   
            'id':'16',
            'name': 'saurabhTrainer',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'cloud',
        },
        {   
            'id':'17',
            'name': 'advay',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'python',
        },
        {   
            'id':'18',
            'name': 'prasham',
            'occ': 'Founder and CEO at Example.com',
            'univ': 'Harvard University',
            'exp': '5yrs',
            'role':3,
            'expertArea':'java',
        }
    ];

    var loadSideBarContent = function() {
        for(i=0; i<names.length; i++) {
            var trainerButton = `
                                    <br>
                                    <button class="btn btn-lg btn-light btn-block"  type="button" data-toggle="modal" data-target="#trainerDetails">
                                        <p>${ names[i].name }</p>
                                    </button>
            `;
            $('#sideBarContent').append(trainerButton);
        }
    };

    var loadMentorCurrentTrainings = function() {
        for(i=0; i<5; i++) {
            var div = `
                    <br>
                    <div class="card">
                        <div class="card-header badge-info"><h4>Course name </h4></div>
                        <div class="card-body bg-dark">
                            <div class="container">
                                <div class="row">
                                    <a href="#" class="text-light">Cource Fee : 100$</a>                        
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 text-center">
                                        <h6 class="text-light">Topics</h6>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 text-center">
                                        <h6 class="text-light">Topics</h6>
                                    </div>
                                </div>
                                <div class="row" style="width: 100%">
                                    <div class="progress" style="width: 100%;">
                                        <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                                    </div>        
                                </div>
                            </div>    
                        </div>
                    </div>
        `;
        $('#trainersDiv').append(div); 
        }
    }

    $('#trainersCurrentTrainingButton').click(function() {
        $('#trainersDiv').empty();
        loadMentorCurrentTrainings();
    });
    
    $('#trainersEditButton').click(function() {
        loadTrainersEditContent();
    });

    $('#trainers-notification-button').on('click',function() {
        loadTrainersNotifications();
    });

    var loadTrainersNotifications = function() { 
        var div = `
                    <br>
                    <table class="table table-bordered table-light table-striped ">
                        <tr>
                            <th>Notifications</th>
                        </tr>
                        <tr>
                            <td>You have the payment notification</td>
                        </tr>
                        <tr>
                            <td>You have cource reminder</td>
                        </tr>
                        <tr>
                            <td>You have student missed call!!</td>
                        </tr>
                    </table>
        `;
        $('#trainersDiv').empty();  
        $('#trainersDiv').html(div);
    }

    var loadTrainersEditContent = function() {
        $('#trainersDiv').empty();
        var div = `
                    <br>
                        <div class="container">
                            <form>
                                <div class="row">
                                    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 text-center">
                                        <img src="abc.png" alt="" width="100px" height="100px">
                                    </div>
                                    <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 ">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                <label for="inputEmail4">Email</label>
                                                <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                                                </div>
                                                <div class="form-group col-md-6">
                                                <label for="inputPassword4">Password</label>
                                                <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputAddress">Address</label>
                                                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputAddress2">Address 2</label>
                                                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                <label for="inputCity">City</label>
                                                <input type="text" class="form-control" id="inputCity">
                                                </div>
                                                <div class="form-group col-md-4">
                                                <label for="inputState">State</label>
                                                <select id="inputState" class="form-control">
                                                    <option selected>Choose...</option>
                                                    <option>...</option>
                                                </select>
                                                </div>
                                                <div class="form-group col-md-2">
                                                <label for="inputZip">Zip</label>
                                                <input type="text" class="form-control" id="inputZip">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-check">
                                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                                <label class="form-check-label" for="gridCheck">
                                                    Remember Me
                                                </label>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary">Save  </button>
                                    </div>
                                </div>
                            </form>       
                        </div>
                        <br>
        `;
        $('#trainersDiv').html(div);
    };

    loadSideBarContent();    

    var loadTrainer = function(start, end) {
        $('#trainerProfiles').empty();
        for(i=start; i<end; i++) {
            var div = `
                        <div class="trainers-card">
                        <br>
                        <div class="card">
                            <div class="card-header badge-info"><h4>${ names[i].name }</h4></div>
                            <div class="card-body bg-dark">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                            <!-- <img src="image.png" alt="Profile Photo" style="height: 100px; width: 100px;"/> -->
                                            <span class="fa fa-10x fa-user-graduate "> </span>    
                                        </div>  
                                        <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                                            <div class="row justify-content-center">
                                                <a href="#" class="text-light"><h5> ${ names[i].name } </h5></a>                        
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <h5 class="text-light"> ${ names[i].occ } </h5>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <h6 class="text-light">${ names[i].exp } Experience</h6>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <h6 class="text-light">${ names[i].univ }</h5>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <h6 class="text-light expert-area">${ names[i].expertArea }</h6>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <button class="btn btn-info btn-block text-dark text-center trainersDetailsButton" id="${ names[i].name }" type="button" data-toggle="modal" data-target="#trainerDetails">Contact</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>    
                            </div>
                        </div>
                        </div>
            `;
            $('#trainerProfiles').append(div);
        };
    };

    loadTrainer(0,5);

    $('#page1').click(function() {
        loadTrainer(0,5);
        // $('#prevPage').removeClass('disabled');
    });

    $('#page2').click(function() {
        loadTrainer(5,10);
        $('#prevPage').removeClass('disabled');
    });

    $('#page3').click(function() {
        loadTrainer(10,15);
        $('#prevPage').removeClass('disabled');
        $('#nextPage').addClass('disabled');
    });

    $('.trainersDetailsButton').click(function() {
        for(let i=0 ; i<names.length; i++) {
            if($(this).attr('id') == names[i].name) {
                $('#trainerPopUpHeader').html(names[i].name);
            }
        }    
    }); 

    $('#dashboardDiv').show(function() {});
    // $('#welcomeDiv').show(function() {});

    $('#logIn-logOut-button').click(function() {
        $('#dashboardDiv').hide();
        $('#welcomeDiv').show();
        $('#sign-InOut-Icon').removeClass('fa-sign-out-alt');
        $('#sign-InOut-Icon').addClass('fa-sign-in-alt');
        $('#signInLabel').html('Sign In');
    });
    
    $('form[name="signInForm"]').submit(function($event) {
        event.preventDefault();
        for(i=0 ; i<names.length ; i++) {
            var id = $('form[name="signInForm"]').find('input')[0].value;
            if(id === names[i].id && $('form[name="signInForm"]').find('input')[1].value === names[i].name ) {
                if(names[i].role == 3) {
                    $('#welcomeDiv').hide();
                    $('#dashboardDiv').show(function() {});
                    $('#dashboardContent').hide();
                    $('#trainersPage').show();
                    // loadMentorCurrentTrainings();
                    break;
                } else if(names[i].role == 2) {
                    $('#welcomeDiv').hide();
                    $('#dashboardDiv').show();
                    $('#trainersPage').hide();
                    $('#dashboardContent').show();
                    break;                          
                }
            }
        }
        $('#sign-InOut-Icon').removeClass('fa-sign-in-alt');
        $('#sign-InOut-Icon').addClass('fa-sign-out-alt');
        $('#signInLabel').html('Sign Out');
    });
});
