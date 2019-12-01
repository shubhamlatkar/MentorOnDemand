$(document).ready(function() {
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

    $('.trainerUser-dropdown-menu a').on('click', function() {
        $('.admin-userTrainer-toggle-header').html($(this).text() + ` <span class="fa fa-arrow-alt-circle-down"></span>`);
        let tem;
        if($(this).text().toLowerCase().trim() == 'trainers') {
            tem = 3;
        } else {
            tem = 2;
        }                
        let list;        
        for(i=0; i<names.length; i++) {
            if(names[i].role == tem) {
                list += `
                        <tr><td><a href="#"> ${ names[i].name } </a></td></tr>
                `;
            }        
        }
        $('.trainerUser-list tbody').empty();
        $('.trainerUser-list tbody').html(list);
    });
});