
   // This example adds a search box to a map, using the Google Place Autocomplete
   // feature. People can enter geographical searches. The search box will return a
   // pick list containing a mix of places and predicted search terms.

   // This example requires the Places library. Include the libraries=places
   // parameter when you first load the API. For example:
   // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

   function initAutocomplete() {
     var map = new google.maps.Map(document.getElementById('map'), {

           center: {
             lat:-37.814,
             lng: 144.9631
           },
           zoom: 4,
           disableDefaultUI: true
         });

         // Create the search box and link it to the UI element.
         var input = document.getElementById('input-location');
         var autocomplete = new google.maps.places.Autocomplete(input);
         map.controls[google.maps.ControlPosition.TOP_CENTER].push(input);
         var marker = new google.maps.Marker({
           map: map
         });

         // Bias the SearchBox results towards current map's viewport.
         autocomplete.bindTo('bounds', map);
         // Set the data fields to return when the user selects a place.
         autocomplete.setFields(
           ['address_components', 'geometry', 'name']);

         // Listen for the event fired when the user selects a prediction and retrieve
         // more details for that place.
         autocomplete.addListener('place_changed', function() {
           var place = autocomplete.getPlace();

              var location =  place.formatted_address;
               var lat =  place.geometry.location.lat() ;
               var longitude =  place.geometry.location.lng() ;

               //location += "Longitude: " + place.geometry.location.lng();
               document.getElementById('lblresult').value = lat
               document.getElementById('longitude').value = longitude
           if (!place.geometry) {
             console.log("Returned place contains no geometry");
             return;
           }
           var bounds = new google.maps.LatLngBounds();
           marker.setPosition(place.geometry.location);

           if (place.geometry.viewport) {
             // Only geocodes have viewport.
             bounds.union(place.geometry.viewport);
           } else {
             bounds.extend(place.geometry.location);
           }
           map.fitBounds(bounds);
         });
       }
       document.addEventListener("DOMContentLoaded", function(event) {
         initAutocomplete();
       });
