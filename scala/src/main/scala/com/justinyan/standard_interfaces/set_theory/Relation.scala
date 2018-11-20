package com.justinyan.standard_interfaces.set_theory

class Relation {}

// Equal variables preserve referential transparency
class EquivalenceRelation extends Relation with Reflexivity with Symmetry with Transitivity {}
class PartialEquivalenceRelation extends Relation with Transitivity with Symmetry {}

class TotalOrder extends Relation with AntiSymmetry with Transitivity with Connex {}
class StrictTotalOrder extends Relation with Transitivity with Asymmetry with Connex {}
class PartialOrder extends Relation with Reflexivity with AntiSymmetry with Transitivity {}
class StrictPartialOrder extends Relation with Irreflexivity with AntiSymmetry with Transitivity {}

class PreOrder extends Relation with Reflexivity with Transitivity {}


// TODO: How to model quasi-opposites not as entirely different traits?
trait Symmetry {}
trait AntiSymmetry {}

trait Transitivity {}

trait Reflexivity {}
trait Irreflexivity {}
trait Connex {}


trait Asymmetry extends AntiSymmetry with Irreflexivity {}
