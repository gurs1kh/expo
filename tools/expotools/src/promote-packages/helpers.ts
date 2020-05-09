import { Parcel } from './types';
import * as Changelogs from '../Changelogs';
import { GitDirectory } from '../Git';
import { Package } from '../Packages';

/**
 * Wraps `Package` object into a parcels - convenient wrapper providing more package-related helpers.
 */
export async function createParcelAsync(pkg: Package): Promise<Parcel> {
  return {
    pkg,
    pkgView: await pkg.getPackageViewAsync(),
    changelog: Changelogs.loadFrom(pkg.changelogPath),
    gitDir: new GitDirectory(pkg.path),
    state: {},
  };
}
