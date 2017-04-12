var exec = require('cordova/exec')

exports.showHelpCentre = function showHelpCentre(s, f) {
  exec(s, f, 'ZendeskPlugin', 'showHelpCentre', []);
}
