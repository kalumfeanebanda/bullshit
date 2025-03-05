import { library } from '@fortawesome/fontawesome-svg-core';
import { faFacebook, faYoutube, faXTwitter, faInstagram } from '@fortawesome/free-brands-svg-icons';

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faFacebook, faYoutube, faXTwitter, faInstagram);

// Exporting FontAwesomeIcon to be used globally
export { FontAwesomeIcon };
