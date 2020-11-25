$(document).ready(function () {
    const input = $('.search-film-input');
    input.autocomplete('disable');

    input.autocomplete({
        serviceUrl: '/filmotheque/filmAjaxSearch',
        // On active le bouton rechercher si une valeur est présente dans le champ input.
        onSelect: function (suggestion) {
        console.log("la sugg : " + suggestion);
            $('#search-film-btn').removeAttr('disabled');
        },
        autoSelectFirst: true,
    });

    // On désactive le bouton rechercher si aucune valeur n'est présente dans le champ input.
    input.on('keyup', function (e) {
        if (input.val() === '') {
            $('#search-pdv').addAttr('disabled');
        }
    });
});