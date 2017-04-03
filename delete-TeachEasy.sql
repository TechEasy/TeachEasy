start transaction;

use `TeachEasy`;

revoke all privileges on `TeachEasy`.* from 'acme-user'@'%';
revoke all privileges on `TeachEasy`.* from 'acme-manager'@'%';

drop user 'acme-user'@'%';
drop user 'acme-manager'@'%';

drop database `TeachEasy`;

commit;